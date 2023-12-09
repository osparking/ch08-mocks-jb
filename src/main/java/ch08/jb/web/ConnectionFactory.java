package ch08.jb.web;

import java.io.InputStream;

public interface ConnectionFactory {
	InputStream getData() throws Exception;
}
