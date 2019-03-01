package todoly.controllers;

import java.util.Scanner;

import todoly.util.enums.MenuOption;

public abstract class Controller {
	protected MenuOption menuOption;
	protected String errorMessage;
	protected String userInput;
	protected Scanner scanner = new Scanner(System.in);
}
