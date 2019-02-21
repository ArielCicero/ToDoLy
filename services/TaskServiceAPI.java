package todoly.services;

import java.util.Collection;

import todoly.model.Task;

public abstract class TaskServiceAPI {
	private RepositoryService repo;
	private Collection<Task> tasks;

	public TaskServiceAPI(RepositoryService repositoryService) {
		repo = repositoryService;
	}
	
	public abstract Collection<Task> listTasks();

	public abstract Collection<Task> getProjectTasks(int projectId);

	public abstract void updateTask(int taskId);

	public abstract void markAsDone(int taskId);

	public abstract void removeTask(int taskId);

	public abstract void save();

	public abstract String getTaskAmount();

	public abstract String getTaskDoneAmount();

}
