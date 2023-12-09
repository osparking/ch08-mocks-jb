package ch08.jb.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WebClientTest {

	@Test
	@DisplayName("메소드 팩토리 사용 final URL 우회ㅅ")
	void testGetContent() throws MalformedURLException {
		MockHttpURLConnection mockConn = new MockHttpURLConnection();
		mockConn
				.setupGetInputStream(new ByteArrayInputStream("It works".getBytes()));
		TestableWebClient client = new TestableWebClient();
		client.setHttpURLConnection(mockConn);
		String workingContent = client.getContent(new URL("http://localhost"));
		assertEquals("It works", workingContent);
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

