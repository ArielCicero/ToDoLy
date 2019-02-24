package todoly.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todoly.exceptions.RepositoryException;
import todoly.interfaces.RepositoryInterface;
import todoly.model.Project;
import todoly.model.Task;

public class FileRepositoryService implements RepositoryInterface {
	
	private Map<Integer,Task> tasks;
	private Map<Integer,Project> projects;
		
	public FileRepositoryService() {
		tasks = new HashMap<>();
		//tasks.put(2, new Task());
		projects = new HashMap<>();
	}

	@Override
	public List<Task> listTasks(){
		return new ArrayList<Task>(tasks.values());
	}
	
	@Override
	public List<Project> listProjects() {
		return new ArrayList<Project>(projects.values());
	}
	
	@Override
	public Task getTask(Integer id){
		return tasks.get(id);
	}

	@Override
	public void addTask(Task task) throws RepositoryException {
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
