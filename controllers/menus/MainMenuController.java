package todoly.controllers.menus;

import java.util.Scanner;

import todoly.app.MenuOption;
import todoly.controllers.Controller;
import todoly.model.TaskListInterface;
import todoly.views.MainMenuView;

public class MainMenuController extends Controller {

    public MainMenuController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new MainMenuView(), scanner);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
    
    @Override
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.TASK_LISTING_MENU);
        validOptions.put("2", MenuOption.ADD_NEW_TASK);
        validOptions.put("3", MenuOption.TASK_EDITION_MENU);
        validOptions.put("4", MenuOption.SAVE_AND_QUIT);
    }
}
