package todoly.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import todoly.model.TaskList;
import todoly.model.TaskListInterface;

/**
 * The <code>FileRepository</code> class is and implementation of the
 * <code>TaskListRepositoryInterface</code> interface in order to save
 * in a file the status of the <code>ToDoLy</code> App and loaded it
 * when the application restarts.
 *
 * @see TaskListRepositoryInterface
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class FileRepository implements TaskListRepositoryInterface {
    private String path;
    
    public FileRepository(String path) {
        this.path = path;
    }

    /**
     * Logic implemented to perform the loading of an object that implements
     * the TaskListInterface, from a file.
     * @return TaskListInterface object implementation
     * @throws RepositoryException with the corresponding error message for the case.
     * @see TaskListRepositoryInterface#loadTaskList()
     * @see TaskListInterface
     * @see RepositoryException
     */
    @Override
    public TaskListInterface loadTaskList() {
        TaskList taskList = null;
        
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn);){  
            taskList = (TaskList) in.readObject();
         } catch (IOException e) {
             taskList = new TaskList();
         } catch (ClassNotFoundException e2) {
             throw new RepositoryException(e2.getMessage());
         }

        return taskList;
    }

    /**
     * Logic implemented to perform the saving of an object that implements
     * the TaskListInterface, in a file.
     * @param TaskListInterface object implementation
     * @throws RepositoryException with the corresponding error message for the case.
     * @see TaskListRepositoryInterface#saveTaskList()
     * @see TaskListInterface
     * @see RepositoryException
     */
    @Override
    public void saveTaskList(TaskListInterface taskList) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);){  
            out.writeObject(taskList);
         } catch (IOException e) {
             throw new RepositoryException(e.getMessage());
         }
    }


}
