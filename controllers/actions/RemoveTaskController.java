package todoly.controllers.actions;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Task;
import todoly.views.ActionView;

public class RemoveTaskController extends Controller {
    public RemoveTaskController(TaskListInterface taskList, Scanner scanner) {
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );

        Task task = getTask(taskList, view, scanner);
        
        if(task != null) {
            taskList.removeTask(task.getId());
            
            view.tasksAmount = (Integer.parseInt(view.tasksAmount) - 1) + "";
            
            view.printConfirmation("The Next Task Has Been Removed", task.toString());
        }
        displayMenu(view, scanner);

    }
}
