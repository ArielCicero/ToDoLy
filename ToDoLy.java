package todoly;

import java.nio.file.Path;
import java.util.Scanner;

import todoly.controllers.MainController;
import todoly.exceptions.InvalidUserInputException;
import todoly.services.FileRepositoryService;
import todoly.services.RepositoryService;
import todoly.services.TaskService;
import todoly.services.TaskServiceAPI;

public class ToDoLy {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		
		Path path = null;
		
		RepositoryService repositoryService = new FileRepositoryService(path);
		TaskServiceAPI taskService = new TaskService(repositoryService);
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
