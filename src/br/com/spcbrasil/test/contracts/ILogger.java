package br.com.spcbrasil.test.contracts;

public interface ILogger {

	public void log(String message);

	public void log(Object value, String message);
}