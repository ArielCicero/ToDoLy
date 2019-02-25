package todoly.presenters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public abstract class Presenter {
	
	protected String errorMessage;
	protected String[] viewProps;
	protected Map<String,Context> validOptions = new HashMap<>();
	protected String userInput;
	
	Presenter(String[] viewProps, String errorMessage, Scanner scanner){
		setViewProperties(viewProps);
		setErrorMessage(errorMessage);
		setValidOptions();
		displayView();
		userInput = scanner.nextLine();
		validateUserInput(userInput);
		
	}
	
	protected abstract void displayView();
	protected abstract void setValidOptions();
	
	
	protected void setViewProperties(String[] props) {
		viewProps = new String[props.length];
		for (int i = 0; i < props.length; i++) {
			viewProps[i] = props[i];
		}
	}

	protected void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	protected void printErrorMessage() {
		if(errorMessage != null) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("ERROR");
			System.out.println(errorMessage);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");		
		}
	}
	
	protected void validateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
	}
	
	public Context getContext(){
		return validOptions.get(userInput);
	}
}
