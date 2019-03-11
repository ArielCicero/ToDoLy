package todoly.controllers;

import java.util.Scanner;

import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

public class UpdateTaskStatusController extends Controller {

    public UpdateTaskStatusController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // displaying a list of tasks and asking the user to pick one ID
        Task task = gettingTheTaskToProcess(taskList);

        if(task != null) {
            // looping until the user writes a right option to change the status
            do {
                view.askForNewStatus(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                // updating the task status
                // 0 = to do , 1 = done
                switch (userInput) {
                case "0":
                    task = taskList.updateTaskStatus(task, false);
                    break;
                case "1":
                    task = taskList.updateTaskStatus(task, true);
                    break;
    
                default:
                    errorMessage = "Valid options are 0 or 1. [" +
                                    userInput + "] is not a valid option";
                    break;
                }
            }while(errorMessage != null);
            
            
            // confirming operation result
            diplayConfirmation(task);
        }
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
