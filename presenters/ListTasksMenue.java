package todoly.presenters;

import java.util.HashMap;
import java.util.List;

import todoly.enums.Context;
import todoly.model.Task;

public class ListTasksMenue extends Presenter {

	@Override
	public void displayView() {
		@SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) props.get("tasks");
		
		printErrorMessage();
		
		System.out.println("################################################");
		
		if(tasks != null) {
			for (Task task : tasks) {
				System.out.println(task);
			}
		}
		else {
			System.out.println(">> There are no tasks");
		}
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Filtered Tasks By Project");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
	
	@SuppressWarnings("serial")
	@Override
	protected void setValidOptions() {
		validOptions = new HashMap<>() {{
			put("1", Context.LIST_PROJECTS);
			put("2", Context.ADD_TASK_TITLE);
			put("3", Context.EDIT_TASK);
			put("4", Context.SAVE_AND_QUIT);
		}};
	}

}
