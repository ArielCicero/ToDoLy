package todoly.controllers;

import java.util.Scanner;

import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.views.View;

public class RemoveTaskController extends Controller {
    public RemoveTaskController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // displaying a list of tasks and asking the user to pick one ID
        Task task = gettingTheTaskToProcess(taskList);
        
        if(task != null) {
            task = taskList.removeTask(task);
            
            // confirming operation result
            diplayConfirmation(task);
        }
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
