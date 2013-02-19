package com.github.osgi.exception;

public class ServiceUnavailableException extends Exception {

	private static final long serialVersionUID = -2366851878449996133L;

	public ServiceUnavailableException() {
		super();
	}

	public ServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceUnavailableException(String message) {
		super(message);
	}

	public ServiceUnavailableException(Throwable cause) {
		super(cause);
	}

}
