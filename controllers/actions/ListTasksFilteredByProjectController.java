package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.views.ActionView;

public class ListTasksFilteredByProjectController extends Controller {

    public ListTasksFilteredByProjectController(TaskListInterface taskList, Scanner scanner) {
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );
        
        Project project = getProject(taskList, view, scanner);
        
        if(project != null) {
            List<Task> tasksList = taskList.getTasksFilteredByProject(
                                                            project.getId()
                                   );
            if(tasksList != null) {
                Collections.sort(tasksList);
        
                List<String> tasks = tasksToStringList(tasksList);
                view.printList(errorMessage, tasks);
            }
        }
        displayMenu(view, scanner);
    }
}
