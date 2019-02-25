package todoly.presenters;

import java.util.Scanner;

import todoly.enums.Context;

public class ListTasksByDueDate extends Presenter {
	public ListTasksByDueDate(String[] viewProps, String errorMessage, Scanner scanner) {
		super(viewProps,errorMessage,scanner);
	}

	@Override
	public void displayView() {
		
		
		
		System.out.println("###########################################"
						+ "############################################");
		if(viewProps == null || viewProps.length == 0) {
			System.out.println(">> There are no tasks");
		}
		else {
			for (String task : viewProps) {
				System.out.println(task);
				System.out.println();
			}
		}
		printErrorMessage();
		System.out.println("###########################################"
						+ "############################################");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Filter Tasks By Project");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
	
	@Override
	protected void setValidOptions() {
		validOptions.put("1", Context.FILTER_BY_PROJECT);
		validOptions.put("2", Context.ADD_TASK_TITLE);
		validOptions.put("3", Context.EDIT_TASK);
		validOptions.put("4", Context.SAVE_AND_QUIT);
	}
}
