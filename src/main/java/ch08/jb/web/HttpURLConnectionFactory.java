package ch08.jb.web;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HttpURLConnectionFactory implements ConnectionFactory {

	private URL url;

	@Override
	public InputStream getData() throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		return conn.getInputStream();
	}

}
