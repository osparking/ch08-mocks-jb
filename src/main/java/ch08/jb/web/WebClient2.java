package ch08.jb.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class WebClient2 {
	public String getContent(ConnectionFactory connection) {
		String workingContent = null;
		StringBuffer content = new StringBuffer();
		
		try(InputStream is = connection.getData()) {
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			workingContent = new String(bytes, Charset.forName("UTF8"));
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return workingContent;
	}
}
