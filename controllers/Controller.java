package todoly.controllers;

import java.util.Scanner;

import todoly.util.enums.MenuOption;
import todoly.views.View;

public abstract class Controller {
	protected MenuOption menuOption;
	protected String errorMessage;
	protected String userInput;
	protected Scanner scanner;
	protected View view;
	
	protected abstract String validateMenuOption(String userInput);
	protected abstract void setMenuOption(String userInput);
	public abstract MenuOption getMenuOption();

	
	protected void displayMenu(View view, Scanner scanner) {
		do {
			view.printMenu(errorMessage);
			userInput = scanner.nextLine();
			setMenuOption(userInput);
			errorMessage = validateMenuOption(userInput);
		}while(errorMessage != null);
	}
}
