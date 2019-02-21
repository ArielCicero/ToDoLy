package todoly.services;

import java.util.Collection;

import todoly.exceptions.RepositoryException;
import todoly.model.Task;

public abstract class RepositoryService {
    
    public abstract Collection<Task> getTasks() throws RepositoryException;
    
    public abstract void saveTasks(Collection<Task> tasks) throws RepositoryException;
    
}
