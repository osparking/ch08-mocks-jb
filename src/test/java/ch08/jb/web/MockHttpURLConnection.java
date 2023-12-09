package ch08.jb.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpURLConnection extends HttpURLConnection{

	public MockHttpURLConnection() {
		super(null);
	}
	
	protected MockHttpURLConnection(URL u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	public void setupGetInputStream(ByteArrayInputStream byteArrayInputStream) {
		// TODO Auto-generated method stub
		
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

