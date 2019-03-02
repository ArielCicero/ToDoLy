package todoly.interfaces;

import java.util.List;

import todoly.model.Project;
import todoly.model.Task;

public interface TaskListInterface {
    
    List<Task> getTasks();
    
    Task getTask(Integer taskId);
    
    Project getProject(Integer projectId);
    
    List<Project> getProjects();
    
    List<Task> getTasksFilteredByProject(Integer projectId);
    
    void addTask(Task task);

    void removeTask(Integer taskId);
    
    int getTasksAmount();
    
    int getTasksDoneAmount();

    void updateTaskProjectName(String projectName, Task task);
}
