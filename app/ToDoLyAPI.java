package todoly.app;

/**
 * The <code>ToDoLyAPI</code> interface should be implemented by any class
 * whose instances are intended to implement the functionality of the
 * <code>ToDoLy</code> App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 15 Mar 2019
 */
public interface ToDoLyAPI {
    
    void listTasksByDueDate();

    void listTasksFilteredByProject();
    
    void addNewTask();
    
    void updateTaskStatus();
    
    void updateTaskTitle();
    
    void updateTaskDueDate();
    
    void updateTaskProjectName();
    
    void removeTask();
        
    void saveAndQuit();
}
