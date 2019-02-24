package todoly.interfaces;

import java.util.List;

import todoly.model.Project;
import todoly.model.Task;

public interface ServiceInterface {

	void setRepository(RepositoryInterface repositoryInterface);
	
	List<Task> listTasksByDueDate();
	
	List<Project> listProjects();

	List<Task> getProjectTasks(int projectId);

	void updateTask(int taskId, Task task);

	void markAsDone(int taskId);

	void removeTask(int taskId);
	
	Integer getTaskAmount();

	Integer getTaskDoneAmount();

	void save();
}
