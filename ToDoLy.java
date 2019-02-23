package todoly;

import java.nio.file.Path;
import java.util.Scanner;

import todoly.controllers.MainController;
import todoly.exceptions.InvalidUserInputException;
import todoly.interfaces.RepositoryInterface;
import todoly.interfaces.ToDoLyInterface;
import todoly.services.FileRepositoryService;
import todoly.services.ToDoLyService;

public class ToDoLy {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		
		Path path = null;
		
		RepositoryInterface repositoryInterface = new FileRepositoryService(path);
		ToDoLyInterface taskService = new ToDoLyService(repositoryInterface);
		MainController controller = new MainController(taskService);        
         
        while(controller.programIsRunning()) {
        	controller.displayView();
        	input = scanner.nextLine();
        	
        	try {
        		controller.ValidateUserInput(input);
            	controller.updateContext(input);
            	controller.updateView();
			} catch (InvalidUserInputException e) {
				controller.setErrorMessage(e.getMessage());
			}
        }
		
        scanner.close();
		
	}
}
