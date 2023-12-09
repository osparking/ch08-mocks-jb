package ch08.jb.web;

import java.io.IOException;
import java.io.InputStream;

public class WebClient2 {
	public String getContent(ConnectionFactory connection) {
		String workingContent = null;
		StringBuffer content = new StringBuffer();
		
		try(InputStream is = connection.getData()) {
			int count;
			while (-1 != (count = is.read())) {
				content.append(new String(Character.toChars(count)));
			}
			workingContent = content.toString();
		} catch (IOException e) {
		} catch (Exception e) {
		}
		return workingContent;
	}
}
