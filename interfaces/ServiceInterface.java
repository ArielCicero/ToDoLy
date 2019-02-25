package todoly.interfaces;

import todoly.model.Task;

public interface ServiceInterface {

	void setRepository(RepositoryInterface repositoryInterface);
	
	String[] listTasksByDueDate();
	
	String[]listProjects();

	String[] getProjectTasks(int projectId);

	void updateTask(int taskId, Task task);

	void markAsDone(int taskId);

	void removeTask(int taskId);
	
	String getTasksAmount();

	String getTasksDoneAmount();

	void save();
}
