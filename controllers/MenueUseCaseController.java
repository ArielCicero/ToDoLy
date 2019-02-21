package todoly.controllers;

import java.util.Map;
import java.util.Set;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;

abstract class MenueUseCaseController extends UseCaseController {
	
	protected Map<String,Context> validMenuOptions;
	

	@Override
	public void ValidateUserInput(String input) throws InvalidUserInputException {
		Set<String> options = validMenuOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new InvalidUserInputException("Invalid Input!!! The options are " + options);
		}
	}

	@Override
	public Context getContext(String input) {
		return validMenuOptions.get(input);
	}

}
