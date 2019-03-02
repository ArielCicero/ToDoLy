package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.interfaces.TaskListInterface;
import todoly.util.enums.MenuOption;
import todoly.views.menus.ListingMenuView;

public class ListingMenuController extends Controller {

    public ListingMenuController(TaskListInterface taskList, Scanner scanner) {
        displayMenu(new ListingMenuView(
                            Integer.toString(taskList.getTasksAmount()),
                            Integer.toString(taskList.getTasksDoneAmount())
                    ), scanner);
    }

    @Override
    protected void setMenuOption() {
        validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
        validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
    }
}
