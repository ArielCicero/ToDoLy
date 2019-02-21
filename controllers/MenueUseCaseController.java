package todoly.controllers;

import java.util.Map;
import java.util.Set;

import todoly.Context;
import todoly.exceptions.InvalidUserInputException;

abstract class MenueUseCaseController extends UseCaseController {
	
	protected Map<String,Context> validMenuOptions;
	

	@Override
	public void ValidateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validMenuOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! the options are " + options);
		}
	}

	@Override
	public Context getContext(String input) {
		return validMenuOptions.get(input);
	}

}
