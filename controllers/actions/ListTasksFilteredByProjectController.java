package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.views.actions.edition.ActionView;

public class ListTasksFilteredByProjectController extends Controller {

	public ListTasksFilteredByProjectController(TaskListInterface taskList, Scanner scanner) {
		ActionView view = new ActionView();
		
		List<Project> projectList = taskList.getProjects();
		Collections.sort(projectList);
		
		List<String> projects = projectsToStringList(projectList);
		view.printList(null, projects);
		
		Project project = null;
		do {
			view.askForInput(errorMessage, "one of the listed Project ID");
			userInput = scanner.nextLine();
			try {
				project = taskList.getProject(Integer.parseInt(userInput));
				errorMessage = null;
				if(project == null) {
					errorMessage = "The option selected was not correct, try again";
				}
			} catch (NumberFormatException e) {
				errorMessage = e.getMessage()
								.replace("For input string", "Wrong value");
			}
		}while(errorMessage != null);
		
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);

		List<String> tasks = tasksToStringList(taskList.getTasks());
		view.printList(errorMessage, tasks);
		
		displayMenu(view, scanner);
	}
}
