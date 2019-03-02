package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.views.actions.edition.ActionView;

public class AddNewTaskController extends Controller {

	public AddNewTaskController(TaskListInterface taskList, Scanner scanner) {
		
		ActionView view = new ActionView();
		
		List<Project> projectList = taskList.getProjects();
		Collections.sort(projectList);
		
		List<String> projects = projectsToStringList(projectList);

		
		Project project = null;
		
		view.printList(null, projects);
		
		do {
			view.askForInput(errorMessage, "one of the listed Project ID or  otherwise a New Project Name");
			userInput = scanner.nextLine();
			
			try {
				Integer projectId = Integer.parseInt(userInput);
				project = taskList.getProject(projectId);
				
				errorMessage = null;
				if(project == null) {
					errorMessage = "There is no Project with id number " + userInput;
				}
				
			} catch (NumberFormatException e) {
				try {
					project = new Project(userInput);
				} catch (ToDoLyException e2) {
					errorMessage = e2.getMessage();
				}
			}
		}while(errorMessage != null);
		
		Task task = new Task();
		task.setProject(project);
		
		do {
			view.askForInput(errorMessage, "Due Date (date format YYYY-MM-DD = \"2012-7-1\")");
			userInput = scanner.nextLine();
			
			try {
				// date format YYYY-MM-DD = "2012-7-1"
				task.setDueDate(new Date(userInput));
				
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
		
		do {
			view.askForInput(errorMessage, "New Task Title");
			userInput = scanner.nextLine();
			
			try {
				task.setTitle(userInput);
				taskList.addTask(task);
				
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
		}while(errorMessage != null);
		
		view.printConfirmation("The Task Has Been Added Successfully", task.toString());
		
		displayMenu(view, scanner);
	}
}
