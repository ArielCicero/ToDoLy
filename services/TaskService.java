package todoly.services;

import java.util.Collections;
import java.util.List;

import todoly.interfaces.RepositoryService;
import todoly.interfaces.TaskManagerAPI;
import todoly.model.Project;
import todoly.model.Task;

public class TaskService implements TaskManagerAPI {
	
	private RepositoryService repo;
	
	private List<Task> tasks;
	private List<Project> projects;

	public TaskService(RepositoryService repositoryService) {
		setRepository(repositoryService);
	}
	
	@Override
	public void setRepository(RepositoryService repositoryService) {
		this.repo = repositoryService;
	}

	@Override
	public List<Task> listTasksByDueDate(){
		tasks = repo.readTasks();
		if(tasks != null)
			sort();
		return tasks;
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
		// Harcoded for testing when developing
		return "6";
	}

	@Override
	public String getTaskDoneAmount() {
		// Harcoded for testing when developing
		return "2";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort() {
		Collections.sort(tasks);
	}

}
