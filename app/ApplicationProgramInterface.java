package todoly.app;

import java.util.List;

public abstract class ApplicationProgramInterface {
	
	protected abstract String showTaskDoneAmount();
	
	protected abstract String showTaskAmount();
	
	protected abstract List<String> showTasksByDueDate();
	
	protected abstract List<String> showProjects();
	
	abstract void save();

}
