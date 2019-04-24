package br.com.spcbrasil.test.error;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.IllegalFormatException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class ExceptionHandler {

	public static void handle(Throwable throwable) {
		if (throwable instanceof IllegalFormatException)
			throwable.printStackTrace();
		else if (throwable instanceof InvalidPathException)
			throwable.printStackTrace();
		else if (throwable instanceof NumberFormatException)
			throwable.printStackTrace();
		else if (throwable instanceof IllegalArgumentException)
			throwable.printStackTrace();
		else if (throwable instanceof DOMException)
			throwable.printStackTrace();
		else if (throwable instanceof IndexOutOfBoundsException)
			throwable.printStackTrace();
		else if (throwable instanceof NullPointerException)
			throwable.printStackTrace();
		else if (throwable instanceof SecurityException)
			throwable.printStackTrace();
		else if (throwable instanceof UnsupportedOperationException)
			throwable.printStackTrace();
		else if (throwable instanceof FileNotFoundException)
			throwable.printStackTrace();
		else if (throwable instanceof IOException)
			throwable.printStackTrace();
		else if (throwable instanceof ParseException)
			throwable.printStackTrace();
		else if (throwable instanceof ParserConfigurationException)
			throwable.printStackTrace();
		else if (throwable instanceof SAXException)
			throwable.printStackTrace();
		else if (throwable instanceof FactoryConfigurationError)
			throwable.printStackTrace();
	}
}