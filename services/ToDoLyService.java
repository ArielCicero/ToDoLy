package todoly.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import todoly.interfaces.RepositoryInterface;
import todoly.interfaces.ToDoLyInterface;
import todoly.model.Project;
import todoly.model.Task;

public class ToDoLyService implements ToDoLyInterface {
	
	private RepositoryInterface repo;

	public ToDoLyService(RepositoryInterface repositoryInterface) {
		setRepository(repositoryInterface);
	}
	
	@Override
	public void setRepository(RepositoryInterface repositoryInterface) {
		repo = repositoryInterface;
	}

	@Override
	public List<Task> listTasksByDueDate(){
		List<Task> tasks = repo.listTasks();
		if(tasks != null)
			// Due date order is the natural order implemented for tasks 
			Collections.sort(tasks);
		return tasks;
	}
	
	@Override
	public List<Project> listProjects() {
		List<Project> projects = repo.listProjects();
		if(projects != null)
			// ID order is the natural order implemented for projects 
			Collections.sort(projects);
		return projects;
	}

	@Override
	public List<Task> getProjectTasks(int projectId) {
		return null;
	}

	@Override
	public void updateTask(int taskId, String description) {
	}

	@Override
	public void markAsDone(int taskId) {
	}

	@Override
	public void removeTask(int taskId) {
	}

	@Override
	public void save() {
	}

	@Override
	public String getTaskAmount() {
		return Integer.toString(repo.listTasks().size());
	}

	@Override
	public String getTaskDoneAmount() {
		return Integer.toString(
				repo.listTasks().stream()
								.filter(x->x.isDone())
								.collect(Collectors.toList())
								.size()
				);
	}
}
