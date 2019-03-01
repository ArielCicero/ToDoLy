package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.ListTasksFilteredByProjectView;

public class ListTasksFilteredByProjectController extends Controller {

	public ListTasksFilteredByProjectController(TaskListInterface taskList) {
		ListTasksFilteredByProjectView view = new ListTasksFilteredByProjectView();
		
		List<Project> projectList = taskList.getProjects();
		Collections.sort(projectList);
		List<String> projects = parseProjects(projectList);
		
		do {
			view.askForProject(errorMessage, projects);
			userInput = scanner.nextLine();
			errorMessage = validateProjectSelection(userInput, taskList);
		}while(errorMessage != null);
		
		List<Task> tasksList = taskList.getTasks();
		Collections.sort(tasksList);
		List<String> tasks = parseTasks(taskList.getTasks());
		
		view.printList(errorMessage, tasks);
		
		do {
			view.printMenu(errorMessage);
			userInput = scanner.nextLine();
			setMenuOption(userInput);
			errorMessage = validateUserInput(userInput);
		}while(errorMessage != null);
		scanner.close();
	}

	private String validateUserInput(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	private void setMenuOption(String userInput) {
		// TODO Auto-generated method stub
		
	}

	private List<String> parseTasks(List<Task> list) {
		// TODO Auto-generated method stub
		return null;
	}

	private String validateProjectSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> parseProjects(List<Project> projects) {
		// TODO Auto-generated method stub
		return null;
	}

	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
