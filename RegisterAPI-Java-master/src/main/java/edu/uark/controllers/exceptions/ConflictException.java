package edu.uark.controllers.exceptions;

public class ConflictException extends RuntimeException {
	public ConflictException(String parameterName) {
		super("Conflict on parameter: ".concat(parameterName));
	}

	private static final long serialVersionUID = 1597574692430394982L;
}
