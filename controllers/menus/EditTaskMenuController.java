package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.views.menus.EditTaskMenuView;

public class EditTaskMenuController extends Controller {

	public EditTaskMenuController(TaskListInterface taskList, Scanner scanner) {
		displayMenu(new EditTaskMenuView(
							Integer.toString(taskList.getTasksAmount()),
							Integer.toString(taskList.getTasksDoneAmount())
					), scanner);
	}
}
