package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
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
}
