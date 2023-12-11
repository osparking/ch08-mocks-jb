package ch08.jb.web;

import java.io.InputStream;

public class WebClient2 {
	public String getContent(ConnectionFactory connection) {
		String workingContent = null;
		StringBuffer content = new StringBuffer();

		try (InputStream is = connection.getData()) {
			int nextByte;
			while (-1 != (nextByte = is.read())) {
				content.append(String.valueOf((char) nextByte));
			}
			workingContent = content.toString();
		} catch (Exception e) {
			workingContent = null;
		}
		return workingContent;
	}
}
