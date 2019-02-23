package todoly.interfaces;

import java.util.List;

import todoly.model.Project;
import todoly.model.Task;

public interface ToDoLyInterface {

	void setRepository(RepositoryInterface repositoryInterface);
	
	List<Task> listTasksByDueDate();
	
	List<Project> listProjects();

	List<Task> getProjectTasks(int projectId);

	void updateTask(int taskId, String description);

	void markAsDone(int taskId);

	void removeTask(int taskId);
	
	String getTaskAmount();

	String getTaskDoneAmount();

	void save();
}
