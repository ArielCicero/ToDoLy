package todoly;

import todoly.app.TextBasedApp;
import todoly.exceptions.ToDoLyException;
import todoly.repository.FileRepository;

public class ToDoLy {
    
    public static void main(String[] args) {
        try {
            
            String path = "ToDoLy.ser";
            Runnable app = new TextBasedApp(
                    new FileRepository(path)
                    );
            
            app.run();
            
        } catch (ToDoLyException e) {
            System.out.println(e.getMessage());
        }
    }
}
