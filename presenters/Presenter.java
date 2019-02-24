package todoly.presenters;

import java.util.Map;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

public abstract class Presenter {
	
	protected String errorMessage;
	protected Map<String,Object> props;
	protected Map<String,Context> validOptions;
	
	public abstract void displayView();
	protected abstract void setValidOptions();
	
	public void setProperties(Map<String, Object> properties) {
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
			System.out.println("************************************************");
			System.out.println(errorMessage);
			System.out.println("************************************************");
		}
	}
	
	public Context getContext(String input) throws InvalidUserInputException {
		Context context = validOptions.get(input);
		if(context == null) {
			Set<String> options = validOptions.keySet();
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
		return context;
	}
}
