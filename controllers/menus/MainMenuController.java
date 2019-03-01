package todoly.controllers.menus;

import todoly.interfaces.TaskListInterface;
import todoly.util.enums.MenuOption;
import todoly.views.menus.MainMenuView;

public class MainMenuController extends MenuController {

	public MainMenuController(TaskListInterface taskList) {
		super(new MainMenuView(
						Integer.toString(taskList.getTasksAmount()),
						Integer.toString(taskList.getTasksDoneAmount())
			  )
		);
	}

	@Override
	protected String validateUserInput(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setMenuOption(String userInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
