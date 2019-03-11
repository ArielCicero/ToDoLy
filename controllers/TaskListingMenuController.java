package todoly.controllers;

import java.util.Scanner;

import todoly.app.MenuOption;
import todoly.model.TaskListInterface;
import todoly.views.ListingMenuView;

public class TaskListingMenuController extends Controller {

    public TaskListingMenuController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new ListingMenuView(), scanner);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }

    @Override
    protected void setValidMenuOptions() {
        validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
        validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
    }
}
