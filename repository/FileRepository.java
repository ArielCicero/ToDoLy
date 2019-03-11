package todoly.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import todoly.model.TaskList;
import todoly.model.TaskListInterface;

public class FileRepository implements TaskListRepositoryInterface {
    private String path;
    
    public FileRepository(String path) {
        this.path = path;
    }

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
