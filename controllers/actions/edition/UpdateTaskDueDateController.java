package todoly.controllers.actions.edition;

import java.util.List;
import java.util.Scanner;

import todoly.interfaces.TaskListInterface;
import todoly.model.Date;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.UpdateTaskDueDateView;

public class UpdateTaskDueDateController extends EditionController {
	public UpdateTaskDueDateController(TaskListInterface taskList, Scanner scanner) {
		UpdateTaskDueDateView view = new UpdateTaskDueDateView();

		Task task = getTask(taskList, view, scanner);

		
		do {
			view.askNewDueDate(errorMessage);
			
			userInput = scanner.nextLine();
			
			setMenuOption(userInput);
			errorMessage = validateDate(userInput);
		}while(errorMessage != null);
		
		task.setDueDate(new Date(userInput));
		
		view.printConfirmation(task.toString());
		
		displayMenu(view, scanner);
	}
	

	private String validateDate(String userInput) {
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
