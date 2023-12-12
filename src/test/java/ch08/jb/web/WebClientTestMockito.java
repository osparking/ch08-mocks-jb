package ch08.jb.web;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class WebClientTestMockito {
	@Mock
	private InputStream iStream;
	@Mock
	private ConnectionFactory factory;

	@Test
	@DisplayName("URL 내용 읽기 시험 - Mockito")
	void testGetContent() throws Exception {
		Mockito.when(factory.getData()).thenReturn(iStream);
		Mockito.when(iStream.read())
				.thenReturn((int) 'W')
				.thenReturn((int) 'o')
				.thenReturn((int) 'r')
				.thenReturn((int) 'k')
				.thenReturn((int) 's')
				.thenReturn((int) '!')
				.thenReturn(-1);

		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);

		assertEquals("Works!", workingContent);
	}

	@Test
	public void testGetContentCannotCloseInputStream() throws Exception {
		when(factory.getData()).thenReturn(iStream);
		when(iStream.read()).thenReturn(-1);
		doThrow(new IOException("can't close")).when(iStream).close();
		
		WebClient2 client = new WebClient2();
		String workingContent = client.getContent(factory);
		assertNull(workingContent);		
	}
}
