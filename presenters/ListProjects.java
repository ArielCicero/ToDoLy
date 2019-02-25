package todoly.presenters;

import java.util.Scanner;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public class ListProjects extends Presenter {
	
	public ListProjects(String[] viewProps, String errorMessage, Scanner scanner) {
		super(viewProps,errorMessage,scanner);
	}

	@Override
	protected void displayView() {
		
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
	protected void validateUserInput(String input) throws InvalidUserInputException {
		if(!isProjectId(input)) {
			if(!input.equals("0")) {
				throw new InvalidUserInputException("Invalid Input!!! (0) "
									+ "for Main Menue or a valid Project ID");
			}
		}
	}
	
	protected boolean isProjectId(String input) {
		String[] projectsId = getProjectsId();
		if(projectsId != null) {
			for (String id : projectsId) {
				if(input.equals(id)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private String[] getProjectsId() {
		if(viewProps != null) {
			String[] projectsId = new String[viewProps.length];
			for (int i = 0; i < viewProps.length; i++) {
				projectsId[i] = viewProps[i].substring(1, viewProps[i].indexOf("]"));
			}
			return projectsId;
		}
		return null;
	}

	@Override
	protected void setValidOptions() {
		validOptions.put("0", Context.MAIN_MENUE);
		String[] projectsId = getProjectsId();
		if(projectsId != null) {
			for (String id : projectsId) {
				validOptions.put(id, Context.FILTER_BY_PROJECT);
			}
		}
	}
}
