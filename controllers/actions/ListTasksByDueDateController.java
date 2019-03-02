package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.util.comparators.SortByDueDate;
import todoly.views.actions.edition.ActionView;

public class ListTasksByDueDateController extends Controller {

	public ListTasksByDueDateController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView();
		
		List<Task> tasks = taskList.getTasks();
		Collections.sort(tasks, new SortByDueDate());
		
		List<String> tasksParsed = tasksToStringList(taskList.getTasks());
		view.printList(errorMessage, tasksParsed);

//		Task task = null;
//		do {
//			view.printList(errorMessage, tasksParsed);
//			userInput = scanner.nextLine();
//			
//			errorMessage = null;
//			if(task == null) {
//				errorMessage = "The option selected was not correct, try again";
//			}
//		}while(errorMessage != null);
		
		displayMenu(view, scanner);
	}
}
