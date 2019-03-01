package todoly.controllers.menus;

import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.util.enums.MenuOption;
import todoly.views.menus.MainMenuView;

public class MainMenuController extends MenuController {

	public MainMenuController(TaskListInterface taskList, Scanner scanner) {
		displayMenu(new MainMenuView(
						Integer.toString(taskList.getTasksAmount()),
						Integer.toString(taskList.getTasksDoneAmount())
			  )
		);
	}

	
	@Override
	protected String validateUserInput(String userInput) {
		try {
			int option = Integer.parseInt(userInput);
			if(1 > option || option > 4) {
				return "Wrong number. The options are 1, 2, 3, 4";
			}
			return null;
		}
		catch (NumberFormatException e) {
			String message = e.getMessage()
					  .replace("For input string", 
							   "Wrong value"
					  );
			return message + ". The options are 1, 2, 3, 4";
		}
	}

	
	@Override
	protected void setMenuOption(String userInput) {
		switch (userInput) {
		case "1":
			menuOption = MenuOption.LIST_TASKS_MENU;
			break;
		case "2":
			menuOption = MenuOption.ADD_NEW_TASK;
			break;
		case "3":
			menuOption = MenuOption.EDIT_TASK_MENU;
			break;
		case "4":
			menuOption = MenuOption.SAVE_AND_QUIT;
			break;
		}
	}

	
	@Override
	public MenuOption getMenuOption() {
		return menuOption;
	}
}
