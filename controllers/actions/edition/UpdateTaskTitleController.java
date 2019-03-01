package todoly.controllers.actions.edition;

import java.util.List;
import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.UpdateTaskTitleView;

public class UpdateTaskTitleController extends EditionController {
	public UpdateTaskTitleController(TaskListInterface taskList, Scanner scanner) {
		UpdateTaskTitleView view = new UpdateTaskTitleView();

		Task task = getTask(taskList, view, scanner);
		
		do {
			view.askNewTitle(errorMessage);
			
			userInput = scanner.nextLine();
			
			try {
				task.setTitle(userInput);
				errorMessage = null;
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
				
		view.printConfirmation(task.toString());
		
		displayMenu(view , scanner);
		
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


	@Override
	protected String validateMenuOption(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}
}
