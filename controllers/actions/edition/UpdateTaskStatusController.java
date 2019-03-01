package todoly.controllers.actions.edition;

import java.util.List;
import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.UpdateTaskStatusView;

public class UpdateTaskStatusController extends EditionController {

	public UpdateTaskStatusController(TaskListInterface taskList, Scanner scanner) {
		
		UpdateTaskStatusView view = new UpdateTaskStatusView();

		Task task = getTask(taskList, view, scanner);

		
		do {
			view.askTaskStatus(errorMessage);
			
			userInput = scanner.nextLine();
			
			errorMessage = null;
			//0 = to do , 1 = done
			switch (userInput) {
			case "0":
				task.setStatus(false);
				break;
			case "1":
				task.setStatus(false);
				break;

			default:
				errorMessage = "Valid options are 0 and 1. ["+
								userInput + "] is not a valid option";
				break;
			}
		}while(errorMessage != null);
		
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
