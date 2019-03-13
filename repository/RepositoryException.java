package todoly.repository;

import java.io.IOException;

/**
 * The <code>RepositoryException</code> class extends <code>RuntimeException</code>
 * class and is used to reflect exceptions strictly related with the
 * <code>FileRepository</code> class of the <code>ToDoLy</code> App.
 * This class is a wrap around <code>IOException</code> and
 * <code>ClassNotFoundException</code>.
 *
 * @see IOException
 * @see ClassNotFoundException
 * @author  Ariel Cicero
 * @version 1.0, 15 Mar 2019
 */
public class RepositoryException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RepositoryException(String message) {
        super(message);
    }
}
