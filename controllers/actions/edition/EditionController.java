package todoly.controllers.actions.edition;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public abstract class EditionController extends Controller {
		
	protected Task getTask(TaskListInterface taskList, ActionView view, Scanner scanner) {
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);
		
		List<String> tasks = tasksToStringList(taskList.getTasks());
		Collections.sort(tasks);
		
		view.printList(errorMessage, tasks);
		
		Task task = null;
		if(tasks != null) {
			do {
				view.askForTaskId(errorMessage, tasks);
				
				userInput = scanner.nextLine();
				errorMessage = null;
				
				task = taskList.getTask(Integer.parseInt(userInput));
				if(task == null) {
					errorMessage = "The option selected was not correct, try again";
				}
			}while(errorMessage != null);
		}
		
		return task;
	}
}
