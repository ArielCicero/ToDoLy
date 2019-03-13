package todoly.controllers;

import java.util.Scanner;

import todoly.model.BusinessModelException;
import todoly.model.Date;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

/**
 * The <code>UpdateTaskDueDateController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality needed to update the due date of a
 * task in the <code>ToDoLy</code> text based App.
 * @see Controller
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class UpdateTaskDueDateController extends Controller {
    
    /**
     * Since this class has the specific purpose of updating the due date of a task in
     * the application, the constructor initialise the parameters needed for that purpose
     * and works as a template that perform the process intended.
     * @param taskList
     * @param scanner
     * @see TaskListInterface
     * @see Scanner
     */
    public UpdateTaskDueDateController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // displaying a list of tasks and asking the user to pick one ID
        Task task = gettingTheTaskToProcess(taskList);
        Date dueDate = null;
        if(task != null) {
            // looping until the user writes a valid date
            do {
                view.askForDueDate(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // BusinessModelException if user write a non valid date (bad format)
                    // BusinessModelException if user write past date
                    dueDate = new Date(userInput);
                } catch (BusinessModelException e) {
                    errorMessage = e.getMessage();
                }
            }while(errorMessage != null);
            
            // setting a new due date for the selected task
            task = taskList.updateTaskDueDate(task, dueDate);
            
            // confirming operation result
            diplayConfirmation(task);
        }
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
