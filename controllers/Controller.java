package todoly.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import todoly.exceptions.ToDoLyException;
import todoly.model.Project;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.View;

public abstract class Controller {
	protected String errorMessage;
	protected String userInput;
	protected Scanner scanner;
	protected View view;
	protected Map<String,MenuOption> validOptions = new HashMap<>();
	
	
	protected abstract void setMenuOption();
	
	protected void validateMenuOption(String input) throws ToDoLyException {
		Set<String> options = validOptions.keySet();
		if(false == options.stream().anyMatch(input::equals)) {
			throw new ToDoLyException("Invalid Input!!! The options are " + options);
		}
	}
	

	public MenuOption getMenuOption() {
		return validOptions.get(userInput);
	}
	
	protected void displayMenu(View view, Scanner scanner) {
		setMenuOption();
		do {
			view.printMenu(errorMessage);
			userInput = scanner.nextLine();
			setMenuOption();
			try {
				validateMenuOption(userInput);
				errorMessage = null;
			} catch (ToDoLyException e) {
				errorMessage = e.getMessage();
			}
			 
		}while(errorMessage != null);
	}
	
	public List<String> tasksToStringList(List<Task> list) {
		return list.stream().map(x->x.toString()).collect(Collectors.toList());
	}
	
	protected List<String> projectsToStringList(List<Project> list) {
		return list.stream().map(x->x.toString()).collect(Collectors.toList());
	}
}
