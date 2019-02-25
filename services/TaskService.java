package todoly.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import todoly.interfaces.RepositoryInterface;
import todoly.interfaces.ServiceInterface;
import todoly.model.Project;
import todoly.model.Task;

public class TaskService implements ServiceInterface {
	
	private RepositoryInterface repo;

	public TaskService(RepositoryInterface repo) {
		this.repo = repo;
	}
	
	@Override
	public void setRepository(RepositoryInterface repository) {
		repo = repository;
	}

	@Override
	public String[] listTasksByDueDate(){
		List<Task> tasks = repo.listTasks();
		if(tasks != null) {
			// Due date order is the natural order implemented for tasks 
			Collections.sort(tasks);
			return tasks.stream()
						.map(Task::toString)
						.toArray(String[]::new);
		}
		return null;
	}
	
	@Override
	public String[] listProjects() {
		List<Project> projects = repo.listProjects();
		if(projects != null) {
			// ID order is the natural order implemented for projects 
			Collections.sort(projects);
			return projects.stream()
						   .map(Project::toString)
						   .toArray(String[]::new);
		}
		return null;
	}

	@Override
	public String[] getProjectTasks(int projectId) {
		return null;
	}

	@Override
	public void updateTask(int taskId, Task task) {
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
	public String getTasksAmount() {
		return Integer.toString(repo.listTasks().size());
	}

	@Override
	public String getTasksDoneAmount() {
		return Integer.toString(
					repo.listTasks().stream()
					.filter(x->x.isDone())
					.collect(Collectors.toList())
					.size()
				);
	}
}
