package todoly;

import todoly.app.TextBasedApp;
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
 * @version 1.0, 15 Mar 2019
 */
public class ToDoLy {
    
    public static void main(String[] args) {
        try {
            // configuring the path and the name of the file where
            // the file repository will save the App status
            String path = "ToDoLy.ser";
            Runnable app = new TextBasedApp(new FileRepository(path));
            
            // starting App 
            app.run();
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }
}
