package todoly.controllers.menus;

import todoly.util.enums.MenuOption;
import todoly.views.menus.ListingMenuView;

public class ListingMenuController extends MenuController {

	public ListingMenuController() {
		super(new ListingMenuView());
	}

	@Override
	protected String validateUserInput(String userInput) {
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
