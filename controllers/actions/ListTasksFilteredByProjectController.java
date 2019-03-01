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

		
		do {
			view.askForProject(errorMessage, projects);
			userInput = scanner.nextLine();
			errorMessage = validateProjectSelection(userInput, taskList);
		}while(errorMessage != null);
		
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);

		List<String> tasks = tasksToStringList(taskList.getTasks());

		
		view.printList(errorMessage, tasks);
		
		displayMenu(view, scanner);
	}

	private String validateProjectSelection(String userInput, TaskListInterface taskList) {
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
