package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.comparators.SortByDueDate;
import todoly.util.enums.MenuOption;
import todoly.views.actions.ListTasksByDueDateView;

public class ListTasksByDueDateController extends Controller {

	public ListTasksByDueDateController(TaskListInterface taskList, Scanner scanner) {
		ListTasksByDueDateView view = new ListTasksByDueDateView();
		
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList, new SortByDueDate());
		List<String> tasks = parseTasks(taskList.getTasks());
		
		do {
			view.printList(errorMessage, tasks);
			userInput = scanner.nextLine();
			errorMessage = validateTaskSelection(userInput, taskList);
		}while(errorMessage != null);
		
		do {
			view.printMenu(errorMessage);
			userInput = scanner.nextLine();
			setMenuOption(userInput);
			errorMessage = validateUserInput(userInput);
		}while(errorMessage != null);
	}

	private String validateUserInput(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	private void setMenuOption(String userInput) {
		// TODO Auto-generated method stub
		
	}

	private String validateTaskSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> parseTasks(List<Task> tasks) {
		// TODO Auto-generated method stub
		return null;
	}

	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
