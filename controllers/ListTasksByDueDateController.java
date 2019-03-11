package todoly.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.util.SortByDueDate;
import todoly.util.ToStringList;
import todoly.views.View;

public class ListTasksByDueDateController extends Controller {

    public ListTasksByDueDateController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // getting and sorting the tasks that will be displayed to the user
        List<Task> tasks = taskList.getTasks();
        List<String> listOfTasks = null;
        if(tasks != null) {
            Collections.sort(tasks, new SortByDueDate());
            listOfTasks = ToStringList.convert(tasks);
        }
        // displaying the list of tasks sorted by due date
        view.printList(listOfTasks);

        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
