package todoly.controllers;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.views.View;

abstract class UseCaseController {
	protected View view;

	public abstract void ValidateUserInput(String input) throws InvalidUserInputException;

	public abstract Context getContext(String input);
	
	public View getView() {
		return view;
	}

}
