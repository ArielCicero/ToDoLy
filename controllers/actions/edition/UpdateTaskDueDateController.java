package todoly.controllers.actions.edition;

import java.util.List;
import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Date;
import todoly.model.Task;
import todoly.views.actions.edition.UpdateTaskDueDateView;

public class UpdateTaskDueDateController extends EditionController {
	public UpdateTaskDueDateController(TaskListInterface taskList, Scanner scanner) {
		UpdateTaskDueDateView view = new UpdateTaskDueDateView();

		Task task = getTask(taskList, view, scanner);

		
		do {
			view.askNewDueDate(errorMessage);
			
			userInput = scanner.nextLine();
			
			try {
				task.setDueDate(new Date(userInput));
				errorMessage = null;
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
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
