package ch08.jb.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class WebClient {
	public String getContent(MockURL mockURL) {
		StringBuffer content = new StringBuffer();
		try {
			HttpURLConnection connection = (HttpURLConnection)mockURL.openConnection();
			connection.setDoInput(true);
			InputStream is = connection.getInputStream();
			int count;
			while (-1 != (count = is.read())) {
				content.append(new String(Character.toChars(count)));
			}
		} catch(IOException e) {
			return null;
		}
		return content.toString();
	}
}

