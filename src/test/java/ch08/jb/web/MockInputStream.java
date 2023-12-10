package ch08.jb.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MockInputStream extends InputStream {
	private String buffer;
	private int position = 0;
	private int closeCount = 0;

	@Override
	public int read() throws IOException {
		if (position == buffer.length()) {
			return -1;
		}
		return buffer.charAt(position++);
	}

	@Override
	public int read(byte[] bytes) throws IOException {
		byte[] srcBytes = buffer.getBytes("UTF-8");
		System.arraycopy(srcBytes, 0, bytes, 0, srcBytes.length);

		if (buffer == null) {
			return -1;
		}
		return srcBytes.length;
	}

	@Override
	public int available() throws UnsupportedEncodingException {
		return buffer.getBytes("UTF-8").length;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	public void close() throws IOException {
		super.close();
		closeCount++;
	}

	public void verify() {
		if (closeCount != 1) {
			throw new AssertionError("close 가 1 회 아닌 횟수 호출됨");
		}
	}
}
