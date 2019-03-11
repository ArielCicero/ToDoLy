package todoly.controllers.actions;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.model.BusinessModelException;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

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
