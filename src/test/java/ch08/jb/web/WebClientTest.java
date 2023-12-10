package ch08.jb.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WebClientTest {

	@Test
	@DisplayName("연결 공장 사용으로 편하게 URL 종속 메소드 시험")
	void testGetContent()
			throws MalformedURLException, UnsupportedEncodingException {
		MockConnectionFactory factory = new MockConnectionFactory();
		String testStr = "잘 작동 중.";
		factory.setInputStream(
				new ByteArrayInputStream(testStr.getBytes("UTF-8")));

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);

		assertEquals(testStr, workingContent);
	}
}
