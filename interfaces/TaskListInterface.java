package todoly.interfaces;

import java.util.List;

import todoly.model.Project;
import todoly.model.Task;

public interface TaskListInterface {
	
	List<Task> getTasks();
	
	Task getTask(String taskId);
	
	Project getProject(Integer projectId);
	
	List<Project> getProjects();
	
	List<Task> getTasksFilteredByProject(String taskId);
	
	void addTask(Task task);

	void updateTask(Task task);

	void removeTask(String taskId);
	
	int getTasksAmount();
	
	int getTasksDoneAmount();

}
