package todoly.controllers.actions.edition;

import java.util.Scanner;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskTitleController extends EditionController {
	public UpdateTaskTitleController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView(
								Integer.toString(taskList.getTasksAmount()),
								Integer.toString(taskList.getTasksDoneAmount())
							);
		
		Task task = getTask(taskList, view, scanner);
		
		if(task != null) {
			do {
				view.askForInput(errorMessage, "New Title");
				
				userInput = scanner.nextLine();
				errorMessage = null;
				try {
					task.setTitle(userInput);
				} catch (ToDoLyException e) {
					errorMessage = e.getMessage();
				}
			}while(errorMessage != null);
					
			view.printConfirmation("The Task Title Has Been Updated Successfully", task.toString());
		}
		displayMenu(view , scanner);
		
	}
}
