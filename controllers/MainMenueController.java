package todoly.controllers;

import java.util.HashMap;

import todoly.enums.Context;
import todoly.views.MainMenueView;

public class MainMenueController extends ViewController {
	
	public MainMenueController(String taskAmount, String taskDoneAmount) {
		view = new MainMenueView(taskAmount, taskDoneAmount);
		setvalidMenuOptions();
	}

	@SuppressWarnings("serial")
	@Override
	protected void setvalidMenuOptions() {
		validMenuOptions = new HashMap<>() {{
			put("1", Context.LIST_TASKS_MENU);
			put("2", Context.NEW_TASK);
			put("3", Context.EDIT_TASK_MENU);
			put("4", Context.SAVE_AND_QUIT);
		}};		
	}
}
