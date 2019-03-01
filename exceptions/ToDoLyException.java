package todoly.exceptions;

@SuppressWarnings("serial")
public class ToDoLyException extends RuntimeException {
	public ToDoLyException(String message) {
		super(message);
	}
}
