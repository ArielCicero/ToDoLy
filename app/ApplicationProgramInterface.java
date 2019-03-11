package todoly.app;

public interface ApplicationProgramInterface {
    
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
