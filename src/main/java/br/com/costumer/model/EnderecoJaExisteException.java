package br.com.costumer.model;

public class EnderecoJaExisteException extends RuntimeException {

	public EnderecoJaExisteException() {
	}

	public EnderecoJaExisteException(String message) {
		super(message);
	}

	public EnderecoJaExisteException(Throwable cause) {
		super(cause);
	}

	public EnderecoJaExisteException(String message, Throwable cause) {
		super(message, cause);
	}
}
