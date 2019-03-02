package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.actions.edition.ActionView;

public class UpdateTaskTitleController extends EditionController {
	public UpdateTaskTitleController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView();

		Task task = getTask(taskList, view, scanner);
		
		do {
			view.askForInput(errorMessage, "New Title");
			
			userInput = scanner.nextLine();
			
			try {
				task.setTitle(userInput);
				errorMessage = null;
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
				
		view.printConfirmation("The Task Title Has Been Updated Successfully", task.toString());
		
		displayMenu(view , scanner);
		
	}
}
