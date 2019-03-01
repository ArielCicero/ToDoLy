package todoly.controllers.actions.edition;

import java.util.List;

import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.actions.edition.UpdateTaskProjectView;

public class UpdateTaskProjectController extends EditionController {
	public UpdateTaskProjectController(TaskListInterface taskList) {
		UpdateTaskProjectView view = new UpdateTaskProjectView();

		getTaskId(taskList, view);
		
		Task task = taskList.getTask(userInput);
		
		do {
			view.askNewProject(errorMessage);
			
			userInput = scanner.nextLine();
			
			setMenuOption(userInput);
			errorMessage = validateProject(userInput);
		}while(errorMessage != null);
		
		task.setProject(new Project(userInput));
		
		view.printConfirmation(task.toString());
		
		displayMenu(view);
		
		scanner.close();
	}
	

	private String validateProject(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected String validateUserInput(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void setMenuOption(String userInput) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected String validateIdSelection(String userInput, TaskListInterface taskList) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected List<String> parseTasks(List<Task> tasks) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
