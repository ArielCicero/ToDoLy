package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.actions.edition.RemoveTaskView;

public class RemoveTaskController extends EditionController {
	public RemoveTaskController(TaskListInterface taskList, Scanner scanner) {
		RemoveTaskView view = new RemoveTaskView();

		Task task = getTask(taskList, view, scanner);
		
		taskList.removeTask(task.getId());
		
		view.printConfirmation(task.toString());
		
		displayMenu(view, scanner);

	}
}
