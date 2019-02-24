package todoly.presenters;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public class ListProjects extends Presenter {

	@Override
	public void displayView() {
		
		printErrorMessage();
		
		System.out.println("###########################################"
						+ "############################################");
		if(props == null || props.isEmpty()) {
			System.out.println(">> There are no projects");
			System.out.println(">> Write 0 to come back to Main Menu");
		}
		else {
			for (String project : props) {
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
		for (String project : props) {
			if(input.equals(
						project.substring(1, project.indexOf("]"))
					)
			) {System.out.println("lala");return true;}
		}
		return false;
	}

	@Override
	public Context getContext(String input){
		return input.equals("0")? Context.MAIN_MENUE : Context.FILTER_BY_PROJECT;
	}

}
