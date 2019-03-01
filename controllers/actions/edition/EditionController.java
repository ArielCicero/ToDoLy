package todoly.controllers.actions.edition;

import java.util.Collections;
import java.util.List;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.EditionView;

public abstract class EditionController extends Controller {
	
	protected void getTaskId(TaskListInterface taskList, EditionView view) {
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);
		List<String> tasks = parseTasks(taskList.getTasks());
		
		view.printList(errorMessage, tasks);
		
		do {
			view.askForTaskId(errorMessage, tasks);
			userInput = scanner.nextLine();
			errorMessage = validateIdSelection(userInput, taskList);
		}while(errorMessage != null);
	}
	
	protected void displayMenu(EditionView view) {
		do {
			view.printMenu(errorMessage);
			
			userInput = scanner.nextLine();
			
			setMenuOption(userInput);
			errorMessage = validateUserInput(userInput);
		}while(errorMessage != null);
	}
	
	protected abstract List<String> parseTasks(List<Task> tasks);
	protected abstract String validateIdSelection(String userInput, TaskListInterface taskList);
	protected abstract String validateUserInput(String userInput);
	protected abstract void setMenuOption(String userInput);
	public abstract MenuOption getMenuOption();
}
