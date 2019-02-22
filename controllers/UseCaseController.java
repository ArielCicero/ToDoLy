package todoly.controllers;

import java.util.Map;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.views.View;

abstract class UseCaseController {
	protected View view;
	protected Map<String,Context> validMenuOptions;
	
	protected abstract void setvalidMenuOptions();

	public void ValidateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validMenuOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
	}

	public Context getContext(String input) {
		return validMenuOptions.get(input);
	}
	
	public View getView() {
		return view;
	}

}
