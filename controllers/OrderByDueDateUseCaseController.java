package todoly.controllers;

import java.util.List;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.model.Task;
import todoly.views.OrderByDateView;

public class OrderByDueDateUseCaseController extends UseCaseController {
	
	public OrderByDueDateUseCaseController(List<Task> tasks) {
		view = new OrderByDateView(tasks);
	}

	@Override
	public void ValidateUserInput(String input) throws InvalidUserInputException {
		// TODO Auto-generated method stub

	}

	@Override
	public Context getContext(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
