package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.util.enums.MenuOption;
import todoly.views.menus.MenuView;

public abstract class MenuController extends Controller {
	protected MenuView view;
	
	protected void displayMenu(MenuView view, Scanner scanner) {
		this.view = view;
		do {
			view.printMenu(errorMessage);
			
			userInput = scanner.nextLine();
			
			setMenuOption(userInput);
			errorMessage = validateUserInput(userInput);
		}while(errorMessage != null);
		
	}
	
	protected abstract String validateUserInput(String userInput);
	protected abstract void setMenuOption(String userInput);
	public abstract MenuOption getMenuOption();
}
