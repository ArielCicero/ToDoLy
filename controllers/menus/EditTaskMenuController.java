package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.util.enums.MenuOption;
import todoly.views.menus.EditTaskMenuView;

public class EditTaskMenuController extends Controller {

	public EditTaskMenuController(TaskListInterface taskList, Scanner scanner) {
		displayMenu(new EditTaskMenuView(
							Integer.toString(taskList.getTasksAmount()),
							Integer.toString(taskList.getTasksDoneAmount())
					), scanner);
	}
	
	@Override
	protected void setMenuOption() {
		validOptions.put("1", MenuOption.UPDATE_TASK_STATUS);
		validOptions.put("2", MenuOption.UPDATE_TASK_TITLE);
		validOptions.put("3", MenuOption.UPDATE_TASK_DUE_DATE);
		validOptions.put("4", MenuOption.UPDATE_TASK_PROJECT);
		validOptions.put("4", MenuOption.REMOVE_TASK);
	}
}
