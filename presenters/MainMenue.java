package todoly.presenters;

import java.util.HashMap;

import todoly.enums.Context;

public class MainMenue extends Presenter {

	@Override
	public void displayView() {
		String taskAmount = (String) props.get("taskAmount");
		String taskDoneAmount = (String) props.get("taskDoneAmount");
		
		printErrorMessage();
		
		System.out.println("################################################");
		System.out.println(">> Welcome to ToDoLy");
		System.out.println(">> You have "+taskAmount+" tasks todo and "+taskDoneAmount+" tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
	
	@SuppressWarnings("serial")
	@Override
	protected void setValidOptions() {
		validOptions = new HashMap<>() {{
			put("1", Context.LIST_TASKS);
			put("2", Context.ADD_TASK_TITLE);
			put("3", Context.EDIT_TASK);
			put("4", Context.SAVE_AND_QUIT);
		}};		
	}
}
