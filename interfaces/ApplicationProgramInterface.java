package todoly.interfaces;

public interface ApplicationProgramInterface {
	
	void listTasksByDueDate();

	void listTasksFilteredByProject();
	
	void addNewTask();
	
	void updateTaskStatus();
	
	void updateTaskTitle();
	
	void updateTaskDueDate();
	
	void updateTaskProject();
	
	void removeTask();
		
	void saveAndQuit();
}
