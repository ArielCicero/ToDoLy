package todoly.interfaces;

import java.util.List;

import todoly.model.Task;

public interface TaskManagerAPI {

	void setRepository(RepositoryService repositoryService);
	
	List<Task> listTasksByDueDate();

	List<Task> getProjectTasks(int projectId);

	void updateTask(int taskId, String description);

	void markAsDone(int taskId);

	void removeTask(int taskId);
	
	String getTaskAmount();

	String getTaskDoneAmount();

	void save();
	
	void sort();
}
