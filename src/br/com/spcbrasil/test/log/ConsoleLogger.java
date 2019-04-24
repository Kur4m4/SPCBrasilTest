package br.com.spcbrasil.test.log;

import br.com.spcbrasil.test.contracts.ILogger;
import br.com.spcbrasil.test.error.ExceptionHandler;

public class ConsoleLogger implements ILogger {

	public ConsoleLogger() {
		super();
	}

	public void log(String message) {
		logToConsole(false, message, "");
	}

	public void log(Object value, String message) {
		logToConsole(true, value, message);
	}

	private static void logToConsole(boolean newLine, Object value, String message) {
		try {
			if (newLine)
				System.out.println(String.format("%s %s", value, message));
			else
				System.out.print(String.format("%s %s", value, message));
		} catch (Exception e) {
			ExceptionHandler.handle(e);
		}
	}
}