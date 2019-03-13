package todoly.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.util.ToStringList;
import todoly.views.View;

/**
 * The <code>Controller</code> abstract class is general-purpose class that
 * groups common processes followed by the rest of the <code>ToDoLy</code> 
 * App controllers.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public abstract class Controller {
    protected String userInput;
    protected String errorMessage;
    protected View view;
    protected Scanner scanner;
    protected MenuOption chosenMenuOption;
    protected Map<String,MenuOption> validOptions = new HashMap<>();
    
    /**
     * Something important to highlight in the constructor is that  the valid menu options
     * of the view are initialised here.
     * Also the Scanner is passed by reference by the classes that uses the present one so
     * this one does not run in a different thread.
     * @param view
     * @param scanner
     */
    protected Controller(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
        setValidMenuOptions();
    }
    
    /**
     * This class is used to read the user input and to remove any previous error message
     * displayed to the user so the user input can be reevaluated to check if there is erros
     * or not in it.
     */
    protected void scanUserInput(){
        userInput = scanner.nextLine();
        errorMessage = null;
    }
    
    /**
     * This method implements a validation of the user input when having to decide the flow
     * of the program after displaying a menu.
     * @param userInput
     * @return boolean flag
     */
    protected boolean isNotValidMenuOption(String userInput){
        Set<String> options = validOptions.keySet();
        if(false == options.stream().anyMatch(userInput::equals)) {
            return true;
        }
        return false;
    }
    
    public MenuOption getMenuOption() {
        return chosenMenuOption;
    }
    
    protected void setChosenMenuOption(String userInput) {
        chosenMenuOption = validOptions.get(userInput);
    }
    
    /**
     * This method implements the process followed by the controller in order to
     * interact with the user when calling the printMenu method of the view.
     * The printMenu method prints a menu that shows the amount of task done and
     * the amount of tasks to do, for that purpose a taskList object is sent as
     * a parameter and used to set this two amounts needed.
     * @param taskList type TaskListInterface
     * @see TaskListInterface
     */
    protected void displayMenu(TaskListInterface taskList) {
        // initialising the tasks amount info that will be displayed in the menu
        view.setTasksToDoAmount(taskList.getTasksToDoAmount().toString());
        view.setTasksDoneAmount(taskList.getTasksDoneAmount().toString());
        // printing the Menu as many times needed until the user
        // picks a valid option
        do {
            view.printMenu(errorMessage);
            // getting the user input, saving it in a class field
            // and initialising errorMessage to null again
            scanUserInput();
            
            if(isNotValidMenuOption(userInput)) {
                errorMessage = "Invalid Input!!! please write one of the valid menu options";
            }
        }while(errorMessage != null);
        
        // the chosen menu option is saved in a class field
        // so the App can decide which controller will be loaded afterwards
        setChosenMenuOption(userInput);
    }
    
    /**
     * This method gets a task as a parameter to confirm the process done on it.
     * If the task is null means that the performed action did not succeed.
     * @param task type Task
     * @see Task
     */
    protected void diplayConfirmation(Task task) {
        // confirming operation result
        if(task != null) {
            view.printConfirmation("The Operation Has Been Done Successfully", task.toString());
        }
        else {
            view.printConfirmation("No Action Was Done !!", null);
        }
    }
    
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
        validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
        validOptions.put("3", MenuOption.ADD_NEW_TASK);
        validOptions.put("4", MenuOption.UPDATE_TASK_STATUS);
        validOptions.put("5", MenuOption.UPDATE_TASK_TITLE);
        validOptions.put("6", MenuOption.UPDATE_TASK_DUE_DATE);
        validOptions.put("7", MenuOption.UPDATE_TASK_PROJECT_NAME);
        validOptions.put("8", MenuOption.REMOVE_TASK);
        validOptions.put("9", MenuOption.SAVE_AND_QUIT);
    }
    
    /**
     * This method implements the process followed by the controller in order to
     * interact with the user when calling the view to ask for a task id after
     * displaying the tasks in the application.
     * It returns the Task correspondent to a valid id inserted by the user. 
     * @param taskList
     * @return Task
     * @see Task
     */
    protected Task gettingTheTaskToProcess(TaskListInterface taskList) {
        Task task = null;
        // getting and sorting the list of tasks that will be displayed
        List<Task> listOfTasks = taskList.getTasks();
        Collections.sort(listOfTasks);
        
        // preparing the list of tasks to be displayed by the view
        List<String> tasks = ToStringList.convert(listOfTasks);
        // printing the list of tasks
        view.printList(tasks);
        // looping until the user writes a right task ID
        if(listOfTasks != null && !listOfTasks.isEmpty()) {
            do {
                view.askForTaskId(errorMessage, tasks);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // NumberFormatException if userInput is not an integer number
                    task = taskList.getTask(Integer.parseInt(userInput));
                    // if the user wrote a number and it was not one of the displayed IDs 
                    // then task will be null
                    if(task == null) {
                        errorMessage = "There are no tasks with this id: " + userInput;
                    }
                } catch (NumberFormatException e) {
                    errorMessage = e.getMessage().replace("For input string", "Wrong value");
                }
            }while(errorMessage != null);
        }
        return task;
    }
}
