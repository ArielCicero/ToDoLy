package todoly.controllers;

/**
 * The <code>ToDoLyAPI</code> interface should be implemented by any class
 * whose instances are intended to implement the functionality of the
 * <code>ToDoLy</code> App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public interface ToDoLyAPI {
    
    /**
     * The general contract of the method <code>listTasksByDueDate</code> is that
     * any class that implements the <code>ToDoLyAPI</code> interface must implement
     * a functionality to interact with the user in order to list the tasks by its
     * due date.
     */
    void listTasksByDueDate();

    /**
     * The general contract of the method <code>listTasksFilteredByProject</code>
     * is that any class that implements the <code>ToDoLyAPI</code> interface must
     * implement a functionality to interact with the user in order to list the tasks
     * filtered by project.
     */
    void listTasksFilteredByProject();
    
    /**
     * The general contract of the method <code>addNewTask</code> is that any class
     * that implements the <code>ToDoLyAPI</code> interface must implement a
     * functionality to interact with the user in order to add a new task.
     */
    void addNewTask();
    
    /**
     * The general contract of the method <code>updateTaskStatus</code> is that any
     * class that implements the <code>ToDoLyAPI</code> interface must implement a
     * functionality to interact with the user in order to update the task status.
     */
    void updateTaskStatus();
    
    /**
     * The general contract of the method <code>updateTaskTitle</code> is that any
     * class that implements the <code>ToDoLyAPI</code> interface must implement a
     * functionality to interact with the user in order to update the task title.
     */
    void updateTaskTitle();
    
    /**
     * The general contract of the method <code>updateTaskDueDate</code> is that any
     * class that implements the <code>ToDoLyAPI</code> interface must implement a
     * functionality to interact with the user in order to update the task due date.
     */
    void updateTaskDueDate();
    
    /**
     * The general contract of the method <code>updateTaskProjectName</code> is that
     * any class that implements the <code>ToDoLyAPI</code> interface must implement
     * a functionality to interact with the user in order to update the project name
     * of a task.
     */
    void updateTaskProjectName();
    
    /**
     * The general contract of the method <code>removeTask</code> is that any class
     * that implements the <code>ToDoLyAPI</code> interface must implement a
     * functionality to interact with the user in order to remove a task from the
     * <code>ToDoLy</code> App.
     */
    void removeTask();
    
    /**
     * The general contract of the method <code>saveAndQuit</code> is that any
     * class that implements the <code>ToDoLyAPI</code> interface must implement
     * a functionality to save the status of the <code>ToDoLy</code> App that can
     * loaded when restarting the application.
     */
    void saveAndQuit();
}
