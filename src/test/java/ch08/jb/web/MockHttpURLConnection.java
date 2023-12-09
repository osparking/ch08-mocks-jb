package ch08.jb.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpURLConnection extends HttpURLConnection {
	private InputStream stream;

	public MockHttpURLConnection() {
		super(null);
	}

	public InputStream getInputStream() {
		return stream;
	}

	public void setExpectedInputStream(InputStream stream) {
		this.stream = stream;
	}

	protected MockHttpURLConnection(URL u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	public void setupGetInputStream(ByteArrayInputStream byteArrayInputStream) {
		stream = byteArrayInputStream;
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean usingProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void connect() throws IOException {
		// TODO Auto-generated method stub

	}
}
