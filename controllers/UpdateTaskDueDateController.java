package todoly.controllers;

import java.util.Scanner;

import todoly.model.BusinessModelException;
import todoly.model.Date;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

public class UpdateTaskDueDateController extends Controller {
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
                    // BusinessModelException if date is not valid
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