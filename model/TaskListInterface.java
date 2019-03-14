package todoly.model;

import java.util.List;

/**
 * The <code>TaskListInterface</code> interface should be implemented by any
 * class whose instances are intended to implement the functionality of a task
 * list for the <code>ToDoLy</code> App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public interface TaskListInterface {
    
    /**
     * The general contract of the method <code>getTasks</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks and give the possibility to the consumer of this service
     * to get a list of this tasks.
     * @return List<Task> object type representing the list of task required
     * @see Task
     */
    List<Task> getTasks();
    
    /**
     * The general contract of the method <code>getProject</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks and since they belong to projects, the possibility of getting
     * a particular project trouhgout its ID must be given to the consumer of this service. 
     * @param projectId
     * @return Project object type required
     * @see Project
     */
    Project getProject(Integer projectId);
    
    /**
     * The general contract of the method <code>getProject</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks and since they belong to projects, the possibility of getting
     * a particular project trouhgout its name must be given to the consumer of this service. 
     * @param projectName
     * @return Project object type required
     * @see Project
     */
    Project getProject(String projectName);
    
    /**
     * The general contract of the method <code>getProjects</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks and since they belong to projects, the possibility of getting
     * a list of the projects must be given to the consumer of this service.  
     * @return List<Project> object type object type representing the list of projects required
     * @see Project 
     */
    List<Project> getProjects();
    
    /**
     * Any class that implements the <code>TaskListInterface</code> interface must
     * implement a collection of tasks with a status (done or to do) so this method
     * returns the amount of tasks to do to the consumer of this service.
     * @return Integer value representing the amount of tasks not done
     */
    Integer getTasksToDoAmount();
    
    /**
     * Any class that implements the <code>TaskListInterface</code> interface must
     * implement a collection of tasks with a status (done or to do) so this method
     * returns the amount of tasks done to the consumer of this service.
     * @return Integer value representing the amount of tasks done
     */
    Integer getTasksDoneAmount();
    
    /**
     * The general contract of the method <code>addTask</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks, therefore the functionality to add a task must be given
     * to the consumer of this service.
     * @param project
     * @param date
     * @param taskTitle
     * @return Task object type representing the task added
     * @see Task
     * @see Date
     */
    Task addTask(Project project, Date date, String taskTitle);
    
    /**
     * The general contract of the method <code>getTask</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks, therefore the possibility of getting a particular task
     * trouhgout its ID must be given to the consumer of this service.
     * @param taskId
     * @return Task object type representing the task required
     * @see Task
     */
    Task getTask(Integer taskId);
    
    /**
     * The general contract of the method <code>removeTask</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a
     * collection of tasks, therefore the functionality of removing a task must be given
     * to the consumer of this service.
     * @param task
     * @return Task object type representing the task removed
     * @see Task
     */
    Task removeTask(Task task);
    
    /**
     * The general contract of the method <code>updateTaskProjectName</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a collection
     * of tasks, therefore the functionality of updating the project name of a task must be given
     * to the consumer of this service.
     * @param task
     * @param projectName
     * @return Task object type representing the task updated
     * @see Task
     */
    Task updateTaskProjectName(Task task, String projectName);

    /**
     * The general contract of the method <code>updateTaskDueDate</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a collection
     * of tasks, therefore the functionality of updating the due date of a task must be given
     * to the consumer of this service.
     * @param task
     * @param dueDate
     * @return Task object type representing the task updated
     * @see Task
     * @see Date
     */
    Task updateTaskDueDate(Task task, Date dueDate);

    /**
     * The general contract of the method <code>updateTaskStatus</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a collection
     * of tasks, therefore the functionality of updating the status of a task must be given
     * to the consumer of this service.
     * @param task
     * @param status
     * @return Task object type representing the task updated
     * @see Task
     */
    Task updateTaskStatus(Task task, boolean status);

    /**
     * The general contract of the method <code>updateTaskTitle</code> is that any class
     * that implements the <code>TaskListInterface</code> interface must implement a collection
     * of tasks, therefore the functionality of updating the title of a task must be given
     * to the consumer of this service.
     * @param task
     * @param title
     * @return Task object type representing the task updated
     * @see Task
     */
    Task updateTaskTitle(Task task, String title);
}
