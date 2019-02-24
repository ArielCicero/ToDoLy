package todoly.presenters;

import java.util.HashMap;

import todoly.enums.Context;

public class MainMenue extends Presenter {

	@Override
	public void displayView() {
		String taskAmount = props.get(0);
		String taskDoneAmount = props.get(1);
		
		printErrorMessage();
		
		System.out.println("###########################################"
						+ "############################################");
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
	/*
	@Override
	public void validateUserInput(String input) throws InvalidUserInputException {
		try {
			Integer value = Integer.parseInt(input);
			if(value < 0 || value > 5) {
				throw new InvalidUserInputException("Wrong value: " + input 
													+ "  - The options are 1, 2, 3, 4");
			}
		} catch (NumberFormatException e) {
			String message = e.getMessage()
					  .replace("For input string", 
							   "Wrong value"
					  );
			message += " - The options are 1, 2, 3, 4";
			throw new InvalidUserInputException(message);
		}
	}
	
	@Override
	public Context getContext(String input){
		switch (input) {
		case "1":
			return Context.LIST_TASKS;
		case "2":
			return Context.ADD_TASK_TITLE;
		case "3":
			return Context.EDIT_TASK;
		case "4":
			return Context.SAVE_AND_QUIT;
		}
		
		throw new RuntimeException("This should never Happen");
	}
	*/
}
