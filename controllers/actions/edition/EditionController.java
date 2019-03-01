package todoly.controllers.actions.edition;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.actions.edition.EditionView;

public abstract class EditionController extends Controller {
	
	//protected abstract List<String> parseTasks(List<Task> tasks);
	protected abstract String validateIdSelection(String userInput, TaskListInterface taskList);
	protected abstract String validateUserInput(String userInput);
	
	protected Task getTask(TaskListInterface taskList, EditionView view, Scanner scanner) {
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);
		//List<String> tasks = parseTasks(taskList.getTasks());
		List<String> tasks = tasksToStringList(taskList.getTasks());
		
		view.printList(errorMessage, tasks);
		
		do {
			view.askForTaskId(errorMessage, tasks);
			userInput = scanner.nextLine();
			errorMessage = validateIdSelection(userInput, taskList);
		}while(errorMessage != null);
		
		return taskList.getTask(Integer.parseInt(userInput));
	}
}
