package todoly.controllers;

import java.util.Scanner;

import todoly.model.BusinessModelException;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

public class UpdateTaskTitleController extends Controller {
    public UpdateTaskTitleController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // displaying a list of tasks and asking the user to pick one ID
        Task task = gettingTheTaskToProcess(taskList);
        
        if(task != null) {
            // looping until the user writes a valid task title
            do {
                view.askForTaskTitle(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                try {
                    // BusinessModelException if the user wrote a non valid task title
                    // or if the new title match with the one of another task
                    // already inside of that project
                    task = taskList.updateTaskTitle(task, userInput);
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
