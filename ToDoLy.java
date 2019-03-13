package todoly;

import todoly.controllers.TextBasedAppController;
import todoly.repository.FileRepository;
import todoly.repository.RepositoryException;

/**
 * The <code>ToDoLy</code> App is a text based todo list application that
 * allows a user to create new tasks, assign them a title and due date, and
 * choose a project for that task to belong to. The user is also able to also
 * edit, mark as done or remove tasks.
 * When the user quits the App, its status is saved in a file, so the
 * application will restart with the former state restored.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class ToDoLy {
    /**
     * This is the main method which makes use of the run method of the
     * <code>TextBasedAppController</code> class, in order to run the
     * <code>ToDoLy</code> text based App. At the same time the constructor of
     * the <code>TextBasedAppController</code> class uses the <code>FileRepository</code>
     * class for implementing a way to save the App status in a file.
     * 
     * @param args Unused.
     * @return Nothing.
     * @exception RepositoryException On errors loading the file.
     * @see TextBasedAppController
     * @see RepositoryException
     */
    public static void main(String[] args) {
        try {
            // configuring the path and the name of the file where
            // the file repository will save the App status
            String path = "ToDoLy.ser";
            Runnable app = new TextBasedAppController(new FileRepository(path));
            
            // starting App 
            app.run();
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }
}
