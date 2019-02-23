package todoly.controllers;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.interfaces.ToDoLyInterface;
import todoly.views.View;

public class MainController {
	
	private ToDoLyInterface taskService;
	private View view;
	private Context context = Context.MAIN_MENUE;
	private ViewController viewController;

	public MainController(ToDoLyInterface taskService) {
		this.taskService = taskService;
		viewController = new MainMenueController(
									taskService.getTaskAmount(),
									taskService.getTaskDoneAmount()
								);
		view = viewController.getView();
	}

	public boolean programIsRunning() {
		return context != Context.SAVE_AND_QUIT;
	}

	public View getView() {
		return view;
	}
	
	public void ValidateUserInput(String input) throws InvalidUserInputException {
		viewController.ValidateUserInput(input);
	}

	public void displayView() {
		view.display();
	}

	public void updateContext(String input) {
		context = viewController.getContext(input);
	}
	
	public void updateView() {
		switch (context) {
		case MAIN_MENUE:
			viewController = new MainMenueController(
										taskService.getTaskAmount(),
										taskService.getTaskDoneAmount()
									);
			break;
		case LIST_TASKS_MENU:
			viewController = new ListTasksMenueController();
			break;
		case ORDER_BY_DUE_DATE:
			viewController = new OrderByDueDateController(taskService.listTasksByDueDate());
			break;
		case LIST_PROJECTS_MENU:
			viewController = new ListProjectsMenuController(taskService.listProjects());
			break;
		case FILTER_BY_PROJECT:
			//viewController = new FilterByProjectController(taskService.getProjectTasks(projectId));
			break;
		/*case NEW_TASK:
			viewController = new NewTaskMenueController();
			break;
		case EDIT_TASK_MENU:
			viewController = new EditTaskMenueController();
			break;
		case UPDATE_TASK:
			viewController = new UpdateTaskMenueController();
			break;
		case MARK_TASK_AS_DONE:
			viewController = new MarkAsDoneMenueController();
			break;
		case REMOVE_TASK:
			viewController = new RemoveTaskMenueController();
			break;
		case SAVE_AND_QUIT:
			viewController = new SaveAndQuitController();
			break;*/

		default:
			viewController = new MainMenueController(
										taskService.getTaskAmount(),
										taskService.getTaskDoneAmount()
									);
		}
		view = viewController.getView();
	}

	public void setErrorMessage(String string) {
		view.setErrorMessage(string);
	}


}
