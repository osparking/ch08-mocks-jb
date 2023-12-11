package ch08.jb.web;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WebClientTestEasyMock {
	private ConnectionFactory factory;
	private InputStream iStream;

	@BeforeEach
	public void setUp() {
		factory = createMock("factory", ConnectionFactory.class);
		iStream = createMock("iStream", InputStream.class);
	}

	@Test
	@DisplayName("URL 읽는 메소드 시험 - EasyMock")
	void testGetContent() throws Exception {
		expect(factory.getData()).andStubReturn(iStream);
		expect(iStream.read()).andReturn(Integer.valueOf((byte) 'W'));
		expect(iStream.read()).andReturn(Integer.valueOf((byte) 'o'));
		expect(iStream.read()).andReturn(Integer.valueOf((byte) 'r'));
		expect(iStream.read()).andReturn(Integer.valueOf((byte) 'k'));
		expect(iStream.read()).andReturn(Integer.valueOf((byte) 's'));
		expect(iStream.read()).andReturn(Integer.valueOf((byte) '!'));
		expect(iStream.read()).andReturn(-1);
		iStream.close();

		replay(factory);
		replay(iStream);

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);

		assertEquals("Works!", workingContent);
	}

	@Test
	public void testGetContentCannotCloseInputStream() throws Exception {
		expect(factory.getData()).andReturn(iStream);
		expect(iStream.read()).andReturn(-1);

		iStream.close();
		expectLastCall().andThrow(new IOException("cannot close"));

		replay(factory);
		replay(iStream);

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);

		assertNull(workingContent);
	}

	@AfterEach
	public void tearDown() {
		verify(factory);
		verify(iStream);
	}
}
