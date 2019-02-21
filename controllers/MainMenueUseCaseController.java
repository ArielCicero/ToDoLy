package todoly.controllers;

import java.util.HashMap;

import todoly.Context;
import todoly.views.MainMenueView;

public class MainMenueUseCaseController extends MenueUseCaseController {
	
	@SuppressWarnings("serial")
	public MainMenueUseCaseController(String taskAmount, String taskDoneAmount) {
		view = new MainMenueView(taskAmount, taskDoneAmount);
		validMenuOptions = new HashMap<>() {{
			put("1", Context.LIST_TASKS);
			put("2", Context.NEW_TASK);
			put("3", Context.EDIT_TASK);
			put("4", Context.SAVE_AND_QUIT);
		}};
	}
}
