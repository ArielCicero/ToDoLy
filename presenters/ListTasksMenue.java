package todoly.presenters;

import java.util.HashMap;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public class ListTasksMenue extends Presenter {

	@Override
	public void displayView() {
		
		printErrorMessage();
		
		System.out.println("###########################################"
						+ "############################################");
		if(props == null || props.isEmpty()) {
			System.out.println(">> There are no tasks");
		}
		else {
			for (String task : props) {
				System.out.println(task);
				System.out.println();
			}
		}
		System.out.println("###########################################"
						+ "############################################");
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
	
	@Override
	public void validateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
	}
	
	@Override
	public Context getContext(String input){
		return validOptions.get(input);
	}

}
