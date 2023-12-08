package ch08.jb.web;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class WebClientTest {

	@Test
	void testGetContent()  {
		MockHttpURLConnection mockConn = new MockHttpURLConnection();
		mockConn.setupGetInputStream(
				new ByteArrayInputStream("It works".getBytes()));
		MockURL mockURL = new MockURL();
		mockURL.setupOpenConnection(mockConn);
		WebClient client = new WebClient();
		String workingContent = client.getContent(mockURL);
		assertEquals("It works", workingContent);		
	}

}
