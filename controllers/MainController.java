package todoly.controllers;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.interfaces.TaskManagerAPI;
import todoly.views.View;

public class MainController {
	
	private TaskManagerAPI taskService;
	private View view;
	private Context context = Context.MAIN_MENUE;
	private UseCaseController useCaseController;

	public MainController(TaskManagerAPI taskService) {
		this.taskService = taskService;
		useCaseController = new MainMenueUseCaseController(
									taskService.getTaskAmount(),
									taskService.getTaskDoneAmount()
								);
		view = useCaseController.getView();
	}

	public boolean programIsRunning() {
		return context != Context.SAVE_AND_QUIT;
	}

	public View getView() {
		return view;
	}
	
	public void ValidateUserInput(String input) throws InvalidUserInputException {
		useCaseController.ValidateUserInput(input);
	}

	public void displayView() {
		view.display();
	}

	public void updateContext(String input) {
		context = useCaseController.getContext(input);
	}
	
	public void updateView() {
		switch (context) {
		case MAIN_MENUE:
			useCaseController = new MainMenueUseCaseController(
										taskService.getTaskAmount(),
										taskService.getTaskDoneAmount()
									);
			break;
		case LIST_TASKS:
			useCaseController = new ListTasksMenueUseCaseController();
			break;
		case ORDER_BY_DUE_DATE:
			useCaseController = new OrderByDueDateUseCaseController(taskService.listTasksByDueDate());
			break;
		case FILTER_BY_PROJECT:
			//useCaseController = new FilterByProjectUseCaseController();
			break;
		/*case NEW_TASK:
			useCaseController = new NewTaskMenueUseCaseController();
			break;
		case EDIT_TASK:
			useCaseController = new EditTaskMenueUseCaseController();
			break;
		case UPDATE_TASK:
			useCaseController = new UpdateTaskMenueUseCaseController();
			break;
		case MARK_TASK_AS_DONE:
			useCaseController = new MarkAsDoneMenueUseCaseController();
			break;
		case REMOVE_TASK:
			useCaseController = new RemoveTaskMenueUseCaseController();
			break;
		case SAVE_AND_QUIT:
			useCaseController = new SaveAndQuitUseCaseController();
			break;*/

		default:
			useCaseController = new MainMenueUseCaseController(
										taskService.getTaskAmount(),
										taskService.getTaskDoneAmount()
									);
		}
		view = useCaseController.getView();
	}

	public void setErrorMessage(String string) {
		view.setErrorMessage(string);
	}


}
