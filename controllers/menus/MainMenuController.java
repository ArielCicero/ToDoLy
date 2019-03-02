package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.util.enums.MenuOption;
import todoly.views.menus.MainMenuView;

public class MainMenuController extends Controller {

    public MainMenuController(TaskListInterface taskList, Scanner scanner) {
        displayMenu(new MainMenuView(
                        Integer.toString(taskList.getTasksAmount()),
                        Integer.toString(taskList.getTasksDoneAmount())
              ),scanner
        );
    }
    
    @Override
    protected void setMenuOption() {
        validOptions.put("1", MenuOption.LIST_TASKS_MENU);
        validOptions.put("2", MenuOption.ADD_NEW_TASK);
        validOptions.put("3", MenuOption.EDIT_TASK_MENU);
        validOptions.put("4", MenuOption.SAVE_AND_QUIT);
    }
}
