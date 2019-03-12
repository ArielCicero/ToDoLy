package todoly.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import todoly.app.MenuOption;
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
 * @version 1.0, 15 Mar 2019
 */
public abstract class Controller {
    protected String userInput;
    protected String errorMessage;
    protected View view;
    protected Scanner scanner;
    protected MenuOption chosenMenuOption;
    protected Map<String,MenuOption> validOptions = new HashMap<>();
    
    protected Controller(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
        setValidMenuOptions();
    }
    
    protected void scanUserInput(){
        userInput = scanner.nextLine();
        errorMessage = null;
    }
        
    protected boolean isNotValidMenuOption(String input){
        Set<String> options = validOptions.keySet();
        if(false == options.stream().anyMatch(input::equals)) {
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
    
    protected void displayMenu(TaskListInterface taskList) {
        // initialising the tasks amount info that will be displayed in the menu
        view.setTasksAmount(taskList.getTasksAmount().toString());
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
