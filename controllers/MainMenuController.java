package todoly.controllers;

import java.util.Scanner;

import todoly.model.TaskListInterface;
import todoly.views.MainMenuView;

/**
 * The <code>MainMenuController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality related to showing the
 * Main Menu of the <code>ToDoLy</code> text based App and getting the user
 * input.
 * @see Controller
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class MainMenuController extends Controller {

    /**
     * Since this class has the specific purpose of displaying the main menu of
     * the application, the constructor initialise the parameters needed for that
     * purpose and works as a template that perform the process intended.
     * @param taskList
     * @param scanner
     * @see TaskListInterface
     * @see Scanner
     */
    public MainMenuController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new MainMenuView(), scanner);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
    
    /**
     * Sets the valid menu options for the menu that will be displayed by the view
     */
    @Override
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.TASK_LISTING_MENU);
        validOptions.put("2", MenuOption.ADD_NEW_TASK);
        validOptions.put("3", MenuOption.TASK_EDITION_MENU);
        validOptions.put("4", MenuOption.SAVE_AND_QUIT);
    }
}
