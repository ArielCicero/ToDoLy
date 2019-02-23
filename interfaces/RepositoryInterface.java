package todoly.interfaces;

import java.util.List;

import todoly.exceptions.RepositoryException;
import todoly.model.Project;
import todoly.model.Task;

public interface RepositoryInterface {
    
    List<Task> listTasks();
    
    List<Project> listProjects();
    
    Task getTask(Integer id);
    
    void addTask(Task task) throws RepositoryException;
    
    void updateTask(Integer id, String description) throws RepositoryException ;
    
    void deleteTask(Integer id) throws RepositoryException;
    
    void save() throws RepositoryException;
    
}
