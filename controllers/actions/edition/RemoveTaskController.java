package todoly.controllers.actions.edition;

import java.util.List;
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

	@Override
	protected String validateUserInput(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setMenuOption() {
//		validOptions.put("1", MenuOption.LIST_TASKS_MENU);
//		validOptions.put("2", MenuOption.ADD_NEW_TASK);
//		validOptions.put("3", MenuOption.EDIT_TASK_MENU);
//		validOptions.put("4", MenuOption.SAVE_AND_QUIT);
	}

	@Override
	protected String validateIdSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> parseTasks(List<Task> tasks) {
		// TODO Auto-generated method stub
		return null;
	}
}
