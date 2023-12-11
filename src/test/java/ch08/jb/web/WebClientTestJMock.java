package ch08.jb.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.imposters.ByteBuddyClassImposteriser;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class WebClientTestJMock {
	@RegisterExtension
	Mockery context = new JUnit5Mockery() {
		{
			setImposteriser(ByteBuddyClassImposteriser.INSTANCE);
		}
	};

	@Test
	@DisplayName("URL 읽는 메소드 시험 - JMock")
	void testGetContent() throws Exception {
		InputStream mockStream = context.mock(InputStream.class);
		ConnectionFactory factory = context.mock(ConnectionFactory.class);

		context.checking(new Expectations() {
			{
				oneOf(factory).getData();
				will(returnValue(mockStream));

				atLeast(1).of(mockStream).read();
				will(onConsecutiveCalls(
						returnValue(Integer.valueOf((byte) 'W')),
						returnValue(Integer.valueOf((byte) 'o')),
						returnValue(Integer.valueOf((byte) 'r')),
						returnValue(Integer.valueOf((byte) 'k')),
						returnValue(Integer.valueOf((byte) 's')),
						returnValue(Integer.valueOf((byte) '!')), 
						returnValue(-1)));

				oneOf(mockStream).close();
			}
		});

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);

		assertEquals("Works!", workingContent);
	}

	@Test
	public void testGetContentCannotCloseInputStream() throws Exception {

		ConnectionFactory factory = context.mock(ConnectionFactory.class);
		InputStream mockStream = context.mock(InputStream.class);

		context.checking(new Expectations() {
			{
				oneOf(factory).getData();
				will(returnValue(mockStream));
				oneOf(mockStream).read();
				will(returnValue(-1));
				oneOf(mockStream).close();
				will(throwException(new IOException("cannot close")));
			}
		});

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);
		assertNull(workingContent);
	}
}
