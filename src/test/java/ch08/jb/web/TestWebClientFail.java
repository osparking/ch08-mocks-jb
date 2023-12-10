package ch08.jb.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestWebClientFail {

	@Test
	@DisplayName("입력흐림이 사용된 뒤 정확히 1회 close 됨")
	void test() {
		MockConnectionFactory factory = new MockConnectionFactory();
		MockInputStream iStream = new MockInputStream();
		String testStr = "잘 되는군!";
		iStream.setBuffer(testStr);
		factory.setInputStream(iStream);

		WebClient2 client = new WebClient2();
		String content = client.getContent(factory);
		assertEquals(testStr, content);
		iStream.verify();
	}

}
