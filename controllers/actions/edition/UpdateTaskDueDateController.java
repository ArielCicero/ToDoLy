package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Date;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskDueDateController extends EditionController {
	public UpdateTaskDueDateController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView();

		Task task = getTask(taskList, view, scanner);

		
		do {
			view.askForInput(errorMessage, "New Due Date");
			
			userInput = scanner.nextLine();
			errorMessage = null;
			
			try {
				task.setDueDate(new Date(userInput));
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
		
		view.printConfirmation("The Task Due Date Has Been Updated Successfully", task.toString());
		
		displayMenu(view, scanner);
	}
}
