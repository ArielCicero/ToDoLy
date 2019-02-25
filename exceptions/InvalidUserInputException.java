package todoly.exceptions;

@SuppressWarnings("serial")
public class InvalidUserInputException extends RuntimeException {
	public InvalidUserInputException(String message) {
		super(message);
	}
}
