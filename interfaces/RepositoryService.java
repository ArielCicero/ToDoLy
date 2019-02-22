package todoly.interfaces;

import java.util.List;

import todoly.exceptions.RepositoryException;
import todoly.model.Task;

public interface RepositoryService {
    
    List<Task> readTasks();
    
    Task readTask(Integer id);
    
    void createTask(Task task) throws RepositoryException;
    
    void updateTask(Integer id, String description) throws RepositoryException ;
    
    void deleteTask(Integer id) throws RepositoryException;
    
    void save() throws RepositoryException;
    
}
