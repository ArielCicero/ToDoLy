package todoly.controllers.actions;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class UpdateTaskProjectController extends Controller {
    public UpdateTaskProjectController(TaskListInterface taskList, Scanner scanner) {
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );

        Task task = getTask(taskList, view, scanner);
        if(task != null) {
            String projectName = task.getProject().getName();
            // in case the new name is the same os an existing project,
            // the task will be moved to the new project
            do {
                view.askForInput(errorMessage, "New Project Name (current = "
                                             + projectName +")");
                
                userInput = scanner.nextLine();
                errorMessage = null;
                
                try {
                    taskList.updateTaskProjectName(userInput, task);
                } catch (ToDoLyException e) {
                    errorMessage = e.getMessage();
                }
            }while(errorMessage != null);
            
            
            view.printConfirmation("The Project Name Has Been Updated Successfully", task.toString());
        }
        displayMenu(view, scanner);
    }
}
