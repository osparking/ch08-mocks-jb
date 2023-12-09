package ch08.jb.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpURLConnection {

	public void setupGetInputStream(ByteArrayInputStream byteArrayInputStream) {
		// TODO Auto-generated method stub
		
	}
	
	private class TestableWebClient extends WebClient1 {
		private HttpURLConnection connection;

		public void setHttpURLConnection(HttpURLConnection connection) {
			this.connection = connection;
		}

		@Override
		protected HttpURLConnection createHttpURLConnection(URL url)
				throws IOException {
			return this.connection;
		}
	}
}

