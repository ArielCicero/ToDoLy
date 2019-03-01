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
	protected String validateMenuOption(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setMenuOption(String userInput) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MenuOption getMenuOption() {
		// TODO Auto-generated method stub
		return null;
	}
}
