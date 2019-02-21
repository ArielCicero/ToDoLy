package todoly.services;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todoly.exceptions.RepositoryException;
import todoly.interfaces.RepositoryService;
import todoly.model.Task;

public class FileRepositoryService implements RepositoryService {
	
	private Path path;
	private Map<Integer,Task> projects;
	private Map<Integer,Task> tasks;
		
	public FileRepositoryService(Path path) {
		this.path = path;
		tasks = new HashMap<>();
		projects = new HashMap<>();
	}

	@Override
	public List<Task> readTasks() throws RepositoryException {
		return (List<Task>) tasks.values();
	}
	
	@Override
	public Task readTask(Integer id) throws RepositoryException {
		return tasks.get(id);
	}

	@Override
	public void createTask(Task task) throws RepositoryException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateTask(Integer id, String description) throws RepositoryException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteTask(Integer id) throws RepositoryException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void save() throws RepositoryException{
		
	}

	

}
