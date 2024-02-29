package exceptions;

public class InvalidInfoException extends RuntimeException {
	
	/**
	 * this exception is used when the info give to a function is invalid
	 * info is any value that should be given by the user
	 */
	
	public InvalidInfoException() {
		super();
	}
	public InvalidInfoException(String message) {
		super(message);
	}
}
