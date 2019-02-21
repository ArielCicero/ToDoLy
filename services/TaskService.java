package todoly.services;

import java.util.Collection;

import todoly.model.Task;

public class TaskService extends TaskServiceAPI {

	public TaskService(RepositoryService repositoryService) {
		super(repositoryService);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Task> listTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Task> getProjectTasks(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTask(int taskId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAsDone(int taskId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTask(int taskId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTaskAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskDoneAmount() {
		// TODO Auto-generated method stub
		return null;
	}

}
