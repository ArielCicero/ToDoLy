package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskProjectController extends EditionController {
	public UpdateTaskProjectController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView(
								Integer.toString(taskList.getTasksAmount()),
								Integer.toString(taskList.getTasksDoneAmount())
							);

		Task task = getTask(taskList, view, scanner);
		
		do {
			view.askForInput(errorMessage, "New Project Name");
			
			userInput = scanner.nextLine();
			errorMessage = null;
			
			try {
				task.getProject().setName(userInput);
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
				
		view.printConfirmation("The Project Name Has Been Updated Successfully", task.toString());
		
		displayMenu(view, scanner);
	}
}
