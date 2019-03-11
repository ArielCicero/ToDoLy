package todoly.app;

import java.util.Scanner;

import todoly.controllers.actions.AddNewTaskController;
import todoly.controllers.actions.ListTasksByDueDateController;
import todoly.controllers.actions.ListTasksFilteredByProjectController;
import todoly.controllers.actions.RemoveTaskController;
import todoly.controllers.actions.UpdateTaskDueDateController;
import todoly.controllers.actions.UpdateTaskProjectNameController;
import todoly.controllers.actions.UpdateTaskStatusController;
import todoly.controllers.actions.UpdateTaskTitleController;
import todoly.controllers.menus.TaskEditionMenuController;
import todoly.controllers.menus.MainMenuController;
import todoly.controllers.menus.TaskListingMenuController;
import todoly.model.TaskListInterface;
import todoly.repository.TaskListRepositoryInterface;

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
            case TASK_LISTING_MENU:
                showTaskListingMenu();
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
            case TASK_EDITION_MENU:
                showTaskEditionMenu();
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
            case UPDATE_TASK_PROJECT_NAME:
                updateTaskProjectName();
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

    public void showTaskListingMenu() {
        menuOption = new TaskListingMenuController(taskList, scanner).getMenuOption();
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
    
    public void showTaskEditionMenu() {
        menuOption = new TaskEditionMenuController(taskList, scanner).getMenuOption();
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
    public void updateTaskProjectName() {
        menuOption = new UpdateTaskProjectNameController(taskList, scanner).getMenuOption();
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
