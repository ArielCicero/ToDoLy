package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.views.menus.EditTaskMenuView;

public class EditTaskMenuController extends Controller {

	public EditTaskMenuController(Scanner scanner) {
		displayMenu(new EditTaskMenuView(), scanner);
	}

	@Override
	protected void setMenuOption() {
//		validOptions.put("1", MenuOption.LIST_TASKS_MENU);
//		validOptions.put("2", MenuOption.ADD_NEW_TASK);
//		validOptions.put("3", MenuOption.EDIT_TASK_MENU);
//		validOptions.put("4", MenuOption.SAVE_AND_QUIT);
	}
}
