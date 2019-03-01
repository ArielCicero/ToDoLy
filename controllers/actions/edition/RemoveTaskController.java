package todoly.controllers.actions.edition;

import java.util.List;
import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.RemoveTaskView;

public class RemoveTaskController extends EditionController {
	public RemoveTaskController(TaskListInterface taskList, Scanner scanner) {
		RemoveTaskView view = new RemoveTaskView();

		getTaskId(taskList, view);
		
		String task = removeTask(taskList, userInput);
		
		view.printConfirmation(task);
		
		displayMenu(view);

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
	protected String validateIdSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> parseTasks(List<Task> tasks) {
		// TODO Auto-generated method stub
		return null;
	}

	private String removeTask(TaskListInterface taskList, String id) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
