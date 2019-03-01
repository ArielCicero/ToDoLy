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

	@Override
	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
