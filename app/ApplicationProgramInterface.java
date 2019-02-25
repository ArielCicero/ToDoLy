package todoly.app;

public abstract class ApplicationProgramInterface {
	
	public abstract void run();
	
	protected abstract void listTasksByDueDate();
	
	protected abstract void listTasksFilterByDate();
	
	protected abstract void addTask();
	
	protected abstract void editTask();
	
	protected abstract void markTaskAsDone();
	
	protected abstract void removeTask();
}
