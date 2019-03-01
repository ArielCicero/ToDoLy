package todoly.controllers.actions.edition;

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
}
