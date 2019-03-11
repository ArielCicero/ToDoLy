package todoly.model;

import java.util.List;

public interface TaskListInterface {
    
    List<Task> getTasks();
        
    Project getProject(Integer projectId);
    
    Project getProject(String projectName);
    
    List<Project> getProjects();
    
    Integer getTasksAmount();
    
    Integer getTasksDoneAmount();
    
    Task addTask(Project project, Date date, String taskTitle);
    
    Task getTask(Integer taskId);
    
    Task removeTask(Task task);

    Task updateTaskProjectName(Task task, String projectName);

    Task updateTaskDueDate(Task task, Date dueDate);

    Task updateTaskStatus(Task task, boolean status);

    Task updateTaskTitle(Task task, String title);

}
