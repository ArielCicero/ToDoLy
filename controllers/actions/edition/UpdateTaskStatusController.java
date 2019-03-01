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
			
			setMenuOption(userInput);
			errorMessage = validateStatus(userInput);
		}while(errorMessage != null);
		
		//0 = to do , 1 = done
		task.setStatus(userInput == "1"); 
		
		view.printConfirmation(task.toString());
		
		displayMenu(view, scanner);
		
	}
	

	private String validateStatus(String userInput) {
		// TODO Auto-generated method stub
		return null;
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
