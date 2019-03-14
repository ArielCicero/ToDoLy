package todoly.controllers;

import java.util.Scanner;

import todoly.model.TaskList;
import todoly.model.TaskListInterface;
import todoly.repository.FileRepository;
import todoly.repository.TaskListRepositoryInterface;

/**
 * The <code>TextBasedApp</code> class is and implementation of the
 * <code>ToDoLyAPI</code> interface in order to follow the requirements
 * of the <code>ToDoLy</code> App mentioned in the project specification
 * for a text base application.
 * This class it also implements the <code>Runnable</code> interface, so
 * it can be executed in a thread.
 * This class uses the <code>Scanner</code> class to read the user input
 * and the <code>MenuOption</code> enum to make the process more readable
 * 
 *
 * @see ToDoLyAPI
 * @see Runnable
 * @see MenuOption
 * @see Scanner
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class TextBasedAppController implements ToDoLyAPI, Runnable{

    private TaskListInterface taskList;
    private TaskListRepositoryInterface fileRepository;
    private MenuOption menuOption = MenuOption.MAIN_MENUE;
    private Scanner scanner = new Scanner(System.in);

    /**
     * This is the only constructor of the class and here is where the taskList object
     * is created either new or with the status that the App had before.
     * This status is loaded thanks to FileRepository class
     * @see TaskListRepositoryInterface
     * @see FileRepository
     * @see TaskListInterface
     * @see TaskList
     */
    public TextBasedAppController(TaskListRepositoryInterface fileRepository) {
        this.fileRepository = fileRepository;
        taskList = fileRepository.loadTaskList();
    }

    /**
     * The purpose of this method is to trigger the start of the <code>ToDoLy</code> App
     * and then it keeps running until the user decides to quit.
     * Here are all the option that the program can take.
     * @see MenuOption
     */
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
        saveAndQuit();
    }
    
    /**
     * This method calls the MainMenuController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for displaying the main menu of the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see MainMenuController
     */
    protected void showMainMenu(){
        menuOption = new MainMenuController(taskList, scanner).getMenuOption();
    }

    /**
     * This method calls the TaskListingMenuController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for displaying the menu related with the different options when listing tasks
     * in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see TaskListingMenuController
     */
    public void showTaskListingMenu() {
        menuOption = new TaskListingMenuController(taskList, scanner).getMenuOption();
    }

    /**
     * This method calls the AddNewTaskController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for adding a new tasks in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see AddNewTaskController
     */
    @Override
    public void addNewTask() {
        menuOption = new AddNewTaskController(taskList, scanner).getMenuOption();       
    }

    /**
     * This method calls the ListTasksByDueDateController class to maintain the code
     * more clean and modular when interacting with the user in order to implement the
     * functionality needed for listing the tasks by its due date in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see ListTasksByDueDateController
     */
    @Override
    public void listTasksByDueDate() {
        menuOption = new ListTasksByDueDateController(taskList, scanner).getMenuOption();       
    }
    
    /**
     * This method calls the ListTasksFilteredByProjectController class to maintain the
     * code more clean and modular when interacting with the user in order to implement
     * the functionality needed for listing the tasks filtered by project in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see ListTasksFilteredByProjectController
     */
    @Override
    public void listTasksFilteredByProject() {
        menuOption = new ListTasksFilteredByProjectController(taskList, scanner).getMenuOption();       
    }
    
    /**
     * This method calls the TaskEditionMenuController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for displaying the menu related with the different options when editing tasks in
     * the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see TaskEditionMenuController
     */
    public void showTaskEditionMenu() {
        menuOption = new TaskEditionMenuController(taskList, scanner).getMenuOption();
    }
    
    /**
     * This method calls the UpdateTaskStatusController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for updating a tasks status in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see UpdateTaskStatusController
     */
    @Override
    public void updateTaskStatus() {
        menuOption = new UpdateTaskStatusController(taskList, scanner).getMenuOption();
    }
    
    /**
     * This method calls the UpdateTaskTitleController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for updating a tasks title in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see UpdateTaskTitleController
     */
    @Override
    public void updateTaskTitle() {
        menuOption = new UpdateTaskTitleController(taskList, scanner).getMenuOption();
    }
    
    /**
     * This method calls the UpdateTaskDueDateController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for updating the due date of a tasks in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see UpdateTaskDueDateController
     */
    @Override
    public void updateTaskDueDate() {
        menuOption = new UpdateTaskDueDateController(taskList, scanner).getMenuOption();
    }
    
    /**
     * This method calls the UpdateTaskProjectNameController class to maintain the code more
     * clean and modular when interacting with the user in order to implement the functionality
     * needed for updating the project name of a tasks in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see UpdateTaskProjectNameController
     */
    @Override
    public void updateTaskProjectName() {
        menuOption = new UpdateTaskProjectNameController(taskList, scanner).getMenuOption();
    }
    
    /**
     * This method calls the RemoveTaskController class to maintain the code more clean
     * and modular when interacting with the user in order to implement the functionality
     * needed for removing a tasks in the application.
     * This method calls the getMenuOption method of the controller to set the option
     * chosen by the user that will be used by the run method later on to decide the
     * flow of the application.
     * @see RemoveTaskController
     */
    @Override
    public void removeTask() {
        menuOption = new RemoveTaskController(taskList, scanner).getMenuOption();
    }

    /**
     * The purpose of this method is to save the status of the <code>ToDoLy</code> App
     * when the user decides to quit it.
     * for that purpose the saveTaskList method of the repository implementation is called.
     * @see TaskListRepositoryInterface
     * @see FileRepository
     */
    @Override
    public void saveAndQuit() {
        scanner.close();
        fileRepository.saveTaskList(taskList);
        Controller.farewell();
    }
}
