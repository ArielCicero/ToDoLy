package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.util.enums.MenuOption;
import todoly.views.menus.ListingMenuView;

public class ListingMenuController extends Controller {

	public ListingMenuController(Scanner scanner) {
		displayMenu(new ListingMenuView(), scanner);
	}

	@Override
	protected void setMenuOption() {
		validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
		validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
	}
}
