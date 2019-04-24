package br.com.spcbrasil.test.log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import br.com.spcbrasil.test.contracts.ILogger;
import br.com.spcbrasil.test.error.ExceptionHandler;

public class TextLogger implements ILogger {

	private static Path path;

	public TextLogger() {
		try {
			path = Path.of("Relatório.txt");
			Files.deleteIfExists(path);
			Files.createFile(path);
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}

	@Override
	public void log(String message) {
		logToText(false, message, "");
	}

	@Override
	public void log(Object value, String message) {
		logToText(true, value, message);
	}

	private static void logToText(boolean newLine, Object value, String message) {
		try {
			Files.writeString(path, String.format("%s %s" + (newLine ? "\n" : ""), value, message), StandardOpenOption.APPEND);
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}
}