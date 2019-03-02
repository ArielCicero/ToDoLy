package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class RemoveTaskController extends EditionController {
	public RemoveTaskController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView(
								Integer.toString(taskList.getTasksAmount()),
								Integer.toString(taskList.getTasksDoneAmount())
							);

		Task task = getTask(taskList, view, scanner);
		
		taskList.removeTask(task.getId());
		
		view.printConfirmation("The Next Task Has Been Removed", task.toString());
		
		displayMenu(view, scanner);

	}
}
