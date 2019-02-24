package todoly.presenters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public abstract class Presenter {
	
	protected String errorMessage;
	protected List<String> props = new ArrayList<>();
	protected Map<String,Context> validOptions;
	
	public abstract void displayView();
	protected abstract void setValidOptions();
	
	public void addPropertie(String propertie) {
		props.add(propertie);
	}
	
	public void setProperties(List<String> properties) {
		props = properties;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	Presenter(){
		setValidOptions();
	}
	
	
	
	public void printErrorMessage() {
		if(errorMessage != null) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("ERROR");
			System.out.println(errorMessage);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");		}
	}
	
	public void validateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
	}
	
	public Context getContext(String input){
		return validOptions.get(input);
	}
}
