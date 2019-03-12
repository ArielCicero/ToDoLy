package todoly.controllers;

import java.util.Scanner;

import todoly.model.BusinessModelException;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

/**
 * The <code>UpdateTaskProjectNameController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality needed to update the project name of a
 * task in the <code>ToDoLy</code> text based App.
 * If the project name decided by the user is not equal to a pre-existing one, a new project
 * with that name is created and the task is moved to it.
 * If the project name decided by the user is equal to a pre-existing one, the task is moved
 * to that project only if that project does not have a task with the same title already.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class UpdateTaskProjectNameController extends Controller {
    public UpdateTaskProjectNameController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // displaying a list of tasks and asking the user to pick one ID
        Task task = gettingTheTaskToProcess(taskList);
        
        if(task != null) {
            // looping until the user writes a valid project name
            do {
                view.askForProjectName(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // in case the written name is the same of an existing project,
                    // the task will be moved to that project
                    // BusinessModelException if is not a valid project name
                    // or if the task title already exist in that project
                    task = taskList.updateTaskProjectName(task, userInput);
                } catch (BusinessModelException e) {
                    errorMessage = e.getMessage();
                }
            }while(errorMessage != null);
            
            // confirming operation result
            diplayConfirmation(task);
        }
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
