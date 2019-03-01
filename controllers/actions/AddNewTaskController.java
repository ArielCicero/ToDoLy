package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.util.enums.MenuOption;
import todoly.views.actions.AddNewTaskView;

public class AddNewTaskController extends Controller {

	public AddNewTaskController(TaskListInterface taskList) {
		AddNewTaskView view = new AddNewTaskView();
		
		List<Project> projectList = taskList.getProjects();
		Collections.sort(projectList);
		List<String> projects = parseProjects(projectList);
		
		do {
			view.askForProject(errorMessage, projects);
			userInput = scanner.nextLine();
			errorMessage = validateProjectSelection(userInput, taskList);
		}while(errorMessage != null);
		
		
		do {
			view.askForTaskTitle(errorMessage);
			userInput = scanner.nextLine();
		}while(errorMessage != null);
		
		do {
			view.askForDueDate(errorMessage);
			userInput = scanner.nextLine();
			errorMessage = validateDate(userInput);
		}while(errorMessage != null);
		
		view.printConfirmation();
		
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

	private String validateProjectSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<String> parseProjects(List<Project> projects) {
		// TODO Auto-generated method stub
		return null;
	}

	private String validateDate(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}

}
