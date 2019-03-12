package todoly.controllers;

import java.util.Scanner;

import todoly.app.MenuOption;
import todoly.model.TaskListInterface;
import todoly.views.TaskEditionMenuView;

/**
 * The <code>TaskEditionMenuController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality related to showing the menu
 * displayed when the user decides to edit a task in the <code>ToDoLy</code> text
 * based App, and also the functionality needed to get the chosen user option.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class TaskEditionMenuController extends Controller {

    public TaskEditionMenuController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new TaskEditionMenuView(), scanner);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
    
    @Override
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.UPDATE_TASK_STATUS);
        validOptions.put("2", MenuOption.UPDATE_TASK_TITLE);
        validOptions.put("3", MenuOption.UPDATE_TASK_DUE_DATE);
        validOptions.put("4", MenuOption.UPDATE_TASK_PROJECT_NAME);
        validOptions.put("5", MenuOption.REMOVE_TASK);
    }
}
