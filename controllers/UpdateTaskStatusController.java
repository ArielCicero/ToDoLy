package todoly.controllers;

import java.util.Scanner;

import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

/**
 * The <code>UpdateTaskStatusController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality needed to update the status of a
 * task in the <code>ToDoLy</code> text based App.
 * @see Controller
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class UpdateTaskStatusController extends Controller {

    /**
     * Since this class has the specific purpose of updating the status of a task in
     * the application, the constructor initialise the parameters needed for that purpose
     * and works as a template that perform the process intended.
     * @param taskList
     * @param scanner
     * @see TaskListInterface
     * @see Scanner
     */
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
