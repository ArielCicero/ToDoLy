package todoly;

import java.util.List;

import todoly.model.Task;

public abstract class ApplicationInterface {
	
	protected abstract Integer getTaskDoneAmount();
	
	protected abstract Integer getTaskAmount();
	
	protected abstract List<Task> listTasksByDueDate();

}
