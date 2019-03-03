package todoly.controllers.actions;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskStatusController extends Controller {

    public UpdateTaskStatusController(TaskListInterface taskList, Scanner scanner) {
        
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );

        Task task = getTask(taskList, view, scanner);

        if(task != null) {
        do {
                view.askForInput(errorMessage, "(1) to mark it as Dono or (0) to mark it as a task To Do");
                
                userInput = scanner.nextLine();
                errorMessage = null;
                
                //0 = to do , 1 = done
                switch (userInput) {
                case "0":
                    task.setStatus(false);
                    break;
                case "1":
                    task.setStatus(true);
                    break;
    
                default:
                    errorMessage = "Valid options are 0 and 1. ["+
                                    userInput + "] is not a valid option";
                    break;
                }
            }while(errorMessage != null);
            
            view.tasksDoneAmount = (1 + Integer.parseInt(view.tasksDoneAmount)) + "";
            
            view.printConfirmation("The Task Status Has Been Updated Successfully", task.toString());
        }
        displayMenu(view, scanner);
    }
}