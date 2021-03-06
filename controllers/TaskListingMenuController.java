package todoly.controllers;

import java.util.Scanner;

import todoly.model.TaskListInterface;
import todoly.views.ListingMenuView;

/**
 * The <code>TaskListingMenuController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality related to showing the menu
 * displayed when the user decides to list the tasks in the <code>ToDoLy</code> text
 * based App, and also the functionality needed to get the chosen user option.
 * @see Controller
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class TaskListingMenuController extends Controller {

    /**
     * Since this class has the specific purpose of displaying a menu for listing
     * the tasks in the application, the constructor initialise the parameters needed
     * for that purpose and works as a template that perform the process intended.
     * @param taskList
     * @param scanner
     * @see TaskListInterface
     * @see Scanner
     */
    public TaskListingMenuController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new ListingMenuView(), scanner);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }

    /**
     * Sets the valid menu options for the menu that will be displayed by the view
     */
    @Override
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
        validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
    }
}
