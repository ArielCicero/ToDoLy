package todoly.model;

/**
 * The <code>BusinessModelException</code> class extends <code>RuntimeException</code>
 * class and is used to reflect exceptions strictly related with the business rules of
 * the model of the <code>ToDoLy</code> text based App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 15 Mar 2019
 */
public class BusinessModelException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessModelException(String message) {
        super(message);
    }
}
