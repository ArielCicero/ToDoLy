package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.actions.edition.UpdateTaskProjectView;

public class UpdateTaskProjectController extends EditionController {
	public UpdateTaskProjectController(TaskListInterface taskList, Scanner scanner) {
		UpdateTaskProjectView view = new UpdateTaskProjectView();

		Task task = getTask(taskList, view, scanner);
		
		do {
			view.askNewProjectName(errorMessage);
			
			userInput = scanner.nextLine();
			
			try {
				task.getProject().setName(userInput);
				errorMessage = null;
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
				
		view.printConfirmation(task.toString());
		
		displayMenu(view, scanner);
	}
}
