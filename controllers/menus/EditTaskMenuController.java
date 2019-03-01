package todoly.controllers.menus;

import todoly.util.enums.MenuOption;
import todoly.views.menus.EditTaskMenuView;

public class EditTaskMenuController extends MenuController {

	public EditTaskMenuController() {
		super(new EditTaskMenuView());
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
