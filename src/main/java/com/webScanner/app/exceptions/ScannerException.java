package com.webScanner.app.exceptions;

public class ScannerException extends Exception {
	private static final long serialVersionUID = 7718828512143293558L;

	public ScannerException() {
		super();
	}

	public ScannerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ScannerException(String message) {
		super(message);
	}

	public ScannerException(Throwable cause) {
		super(cause);
	}
}
