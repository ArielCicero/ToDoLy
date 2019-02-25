package todoly.app;

import java.util.Scanner;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.interfaces.ServiceInterface;
import todoly.presenters.ListProjects;
import todoly.presenters.ListTasksByDueDate;
import todoly.presenters.MainMenue;

public class TextBasedUserInterface extends ApplicationProgramInterface{
	
	private ServiceInterface taskService;
	private Context context;
	private String errorMessage;
	private Scanner scanner = new Scanner(System.in);
	
	
	public TextBasedUserInterface(ServiceInterface taskService) {
		this.taskService = taskService;
		context = Context.MAIN_MENUE;
	}
	
	@Override
	public void run() {
		do {
			try {
				switch (context) {
				case MAIN_MENUE:
					showMainMenu();
					break;
				case LIST_TASKS:
					listTasksByDueDate();
					break;
				case LIST_PROJECTS:
				case FILTER_BY_PROJECT:
					listTasksFilterByDate();
					break;
				default:
					showMainMenu();
					break;
				}
				errorMessage = null;
			} catch (InvalidUserInputException e) {
				errorMessage = e.getMessage();
			}
		}while(context != Context.SAVE_AND_QUIT);
		taskService.save();
		scanner.close();
	}

	private void showMainMenu(){
		String[] viewProps = {
				taskService.getTasksAmount(),
				taskService.getTasksDoneAmount()
		};
		context = new MainMenue(viewProps, errorMessage, scanner).getContext();
	}

	@Override
	protected void listTasksByDueDate(){
		context = new ListTasksByDueDate(
							taskService.listTasksByDueDate(),
							errorMessage,
							scanner
				 ).getContext();
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	protected void listTasksFilterByDate(){
		switch (context) {
		case LIST_PROJECTS:
			context = new ListProjects(
					taskService.listProjects(),
					errorMessage,
					scanner
					).getContext();
			break;

		case FILTER_BY_PROJECT:
			String selectedProjectId = context.values;
			System.out.println("#adc create ListTasksFilterByDate Presenter");
			System.out.println(selectedProjectId);
			scanner.nextLine();
//			context = new ListTasksFilterByDate(
//					/*taskService.listProjects(),*/
//					errorMessage,
//					scanner
//					).getContext();
			break;
		}
	}

	@Override
	protected void addTask() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void editTask() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void markTaskAsDone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void removeTask() {
		// TODO Auto-generated method stub
		
	}
}
