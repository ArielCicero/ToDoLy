package todoly.controllers.actions;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskTitleController extends Controller {
    public UpdateTaskTitleController(TaskListInterface taskList, Scanner scanner) {
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );
        
        Task task = getTask(taskList, view, scanner);
        
        if(task != null) {
            do {
                view.askForInput(errorMessage, "New Title");
                
                userInput = scanner.nextLine();
                errorMessage = null;
                try {
                    task.setTitle(userInput);
                } catch (ToDoLyException e) {
                    errorMessage = e.getMessage();
                }
            }while(errorMessage != null);
                    
            view.printConfirmation("The Task Title Has Been Updated Successfully", task.toString());
        }
        displayMenu(view , scanner);
        
    }
}
