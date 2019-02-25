package todoly.presenters;

import java.util.Scanner;

import todoly.enums.Context;

public class MainMenue extends Presenter {

	public MainMenue(String[] viewProps, String errorMessage, Scanner scanner) {
		super(viewProps,errorMessage,scanner);
	}

	@Override
	protected void displayView() {
		String tasksAmount = viewProps[0];
		String tasksDoneAmount = viewProps[1];
		
		printErrorMessage();
		
		System.out.println("###########################################"
						+ "############################################");
		System.out.println(">> Welcome to ToDoLy");
		System.out.println(">> You have "+tasksAmount+" tasks todo and "+tasksDoneAmount+" tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
	
	@Override
	protected void setValidOptions() {
		validOptions.put("1", Context.LIST_TASKS);
		validOptions.put("2", Context.ADD_TASK_TITLE);
		validOptions.put("3", Context.EDIT_TASK);
		validOptions.put("4", Context.SAVE_AND_QUIT);
	}
}
