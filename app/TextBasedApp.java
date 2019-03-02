package todoly.app;

import java.util.Scanner;

import todoly.controllers.actions.AddNewTaskController;
import todoly.controllers.actions.ListTasksByDueDateController;
import todoly.controllers.actions.ListTasksFilteredByProjectController;
import todoly.controllers.actions.edition.RemoveTaskController;
import todoly.controllers.actions.edition.UpdateTaskDueDateController;
import todoly.controllers.actions.edition.UpdateTaskProjectController;
import todoly.controllers.actions.edition.UpdateTaskStatusController;
import todoly.controllers.actions.edition.UpdateTaskTitleController;
import todoly.controllers.menus.EditTaskMenuController;
import todoly.controllers.menus.ListingMenuController;
import todoly.controllers.menus.MainMenuController;
import todoly.interfaces.ApplicationProgramInterface;
import todoly.interfaces.TaskListInterface;
import todoly.interfaces.TaskListRepositoryInterface;
import todoly.util.enums.MenuOption;

public class TextBasedApp implements ApplicationProgramInterface, Runnable{

	private TaskListInterface taskList;
	private TaskListRepositoryInterface fileRepository;
	private MenuOption menuOption = MenuOption.MAIN_MENUE;
	private Scanner scanner = new Scanner(System.in);

	
	public TextBasedApp(TaskListRepositoryInterface fileRepository) {
		this.fileRepository = fileRepository;
		taskList = fileRepository.loadTaskList();
	}

	@Override
	public void run() {
		do {
			switch (menuOption) {
			case MAIN_MENUE:
				showMainMenu();
				break;
			case LIST_TASKS_MENU:
				showListingMenu();
				break;
			case LIST_TASKS_BY_DUE_DATE:
				listTasksByDueDate();
				break;
			case LIST_TASKS_FILTERED_BY_PROJECT:
				listTasksFilteredByProject();
				break;
			case ADD_NEW_TASK:
				addNewTask();
				break;
			case EDIT_TASK_MENU:
				editTaskMenu();
				break;
			case UPDATE_TASK_STATUS:
				updateTaskStatus();
				break;
			case UPDATE_TASK_TITLE:
				updateTaskTitle();
				break;
			case UPDATE_TASK_DUE_DATE:
				updateTaskDueDate();
				break;
			case UPDATE_TASK_PROJECT:
				updateTaskProject();
				break;
			case REMOVE_TASK:
				removeTask();
				break;
			default:
				break;
			}
		}while(menuOption != MenuOption.SAVE_AND_QUIT);
		scanner.close();
		saveAndQuit();
	}
	
	protected void showMainMenu(){
		menuOption = new MainMenuController(taskList, scanner).getMenuOption();
	}

	public void showListingMenu() {
		menuOption = new ListingMenuController(taskList, scanner).getMenuOption();
	}

	@Override
	public void addNewTask() {
		menuOption = new AddNewTaskController(taskList, scanner).getMenuOption();		
	}

	@Override
	public void listTasksByDueDate() {
		menuOption = new ListTasksByDueDateController(taskList, scanner).getMenuOption();		
	}
	
	@Override
	public void listTasksFilteredByProject() {
		menuOption = new ListTasksFilteredByProjectController(taskList, scanner).getMenuOption();		
	}
	
	public void editTaskMenu() {
		menuOption = new EditTaskMenuController(taskList, scanner).getMenuOption();
	}
	
	@Override
	public void updateTaskStatus() {
		menuOption = new UpdateTaskStatusController(taskList, scanner).getMenuOption();
	}
	
	@Override
	public void updateTaskTitle() {
		menuOption = new UpdateTaskTitleController(taskList, scanner).getMenuOption();
	}
	
	@Override
	public void updateTaskDueDate() {
		menuOption = new UpdateTaskDueDateController(taskList, scanner).getMenuOption();
	}
	
	@Override
	public void updateTaskProject() {
		menuOption = new UpdateTaskProjectController(taskList, scanner).getMenuOption();
	}
	
	@Override
	public void removeTask() {
		menuOption = new RemoveTaskController(taskList, scanner).getMenuOption();
	}

	@Override
	public void saveAndQuit() {
		fileRepository.saveTaskList(taskList);
	}
}
