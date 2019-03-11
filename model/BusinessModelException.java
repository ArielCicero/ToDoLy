package todoly.model;

@SuppressWarnings("serial")
public class BusinessModelException extends RuntimeException {
    public BusinessModelException(String message) {
        super(message);
    }
}
