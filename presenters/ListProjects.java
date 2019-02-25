package todoly.presenters;

import java.util.Scanner;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public class ListProjects extends Presenter {

	public ListProjects(String[] viewProps, String errorMessage, Scanner scanner) {
		super(viewProps,errorMessage,scanner);
	}

	@Override
	public void displayView() {
		
		printErrorMessage();
		
		System.out.println("###########################################"
						+ "############################################");
		if(viewProps == null || viewProps.length == 0) {
			System.out.println(">> There are no projects");
			System.out.println(">> Write 0 to come back to Main Menu");
		}
		else {
			for (String project : viewProps) {
				System.out.println(project);
				System.out.println();
			}
			System.out.println("###########################################"
					+ "############################################");
			System.out.println(">> Write Project ID or 0 to come back to Main Menu");
		}
		System.out.print(">> ");
	}
	
	@Override
	protected void setValidOptions() {
		validOptions = null;
	}
	
	@Override
	public void validateUserInput(String input) throws InvalidUserInputException {
		if(!isProjectId(input)) {
			if(!input.equals("0")) {
				throw new InvalidUserInputException("Invalid Input!!! (0) "
									+ "for Main Menue or a valid Project ID");
			}
		}
	}
	
	private boolean isProjectId(String input) {
		if(viewProps != null) {
			for (String project : viewProps) {
				if(input.equals(
							project.substring(1, project.indexOf("]"))
						)
				) {System.out.println("#adc in ListProject Presenter");return true;}
			}
		}
		return false;
	}

	@Override
	public Context getContext(){
		return userInput.equals("0")? Context.MAIN_MENUE : Context.FILTER_BY_PROJECT;
	}

}
