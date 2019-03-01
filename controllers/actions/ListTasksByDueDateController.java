package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.comparators.SortByDueDate;
import todoly.views.actions.ListTasksByDueDateView;

public class ListTasksByDueDateController extends Controller {

	public ListTasksByDueDateController(TaskListInterface taskList, Scanner scanner) {
		ListTasksByDueDateView view = new ListTasksByDueDateView();
		
		List<Task> tasks = taskList.getTasks();
		Collections.sort(tasks, new SortByDueDate());
		
		List<String> tasksParsed = parseTasks(taskList.getTasks());
		
		do {
			view.printList(errorMessage, tasksParsed);
			userInput = scanner.nextLine();
			errorMessage = validateTaskSelection(userInput, taskList);
		}while(errorMessage != null);
		
		displayMenu(view, scanner);
	}


	private String validateTaskSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> parseTasks(List<Task> tasks) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void setMenuOption() {
//		validOptions.put("1", MenuOption.LIST_TASKS_MENU);
//		validOptions.put("2", MenuOption.ADD_NEW_TASK);
//		validOptions.put("3", MenuOption.EDIT_TASK_MENU);
//		validOptions.put("4", MenuOption.SAVE_AND_QUIT);
	}
}
