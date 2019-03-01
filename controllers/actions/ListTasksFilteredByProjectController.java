package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.views.actions.ListTasksFilteredByProjectView;

public class ListTasksFilteredByProjectController extends Controller {

	public ListTasksFilteredByProjectController(TaskListInterface taskList, Scanner scanner) {
		ListTasksFilteredByProjectView view = new ListTasksFilteredByProjectView();
		
		List<Project> projectList = taskList.getProjects();
		Collections.sort(projectList);
		
		List<String> projects = projectsToStringList(projectList);

		Project project = null;
		do {
			view.askForProject(errorMessage, projects);
			userInput = scanner.nextLine();
			
			project = taskList.getProject(Integer.parseInt(userInput));
			errorMessage = null;
			if(project == null) {
				errorMessage = "The option selected was not correct, try again";
			}
		}while(errorMessage != null);
		
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);

		List<String> tasks = tasksToStringList(taskList.getTasks());

		
		view.printList(errorMessage, tasks);
		
		displayMenu(view, scanner);
	}
}
