package todoly;

import todoly.app.TextBasedApp;
import todoly.repository.FileRepository;
import todoly.repository.RepositoryException;

public class ToDoLy {
    
    public static void main(String[] args) {
        try {
            // comment, config
            String path = "ToDoLy.ser";
            Runnable app = new TextBasedApp(new FileRepository(path));
            
            // start app 
            app.run();
            
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }
}
