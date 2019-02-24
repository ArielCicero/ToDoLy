package todoly;

import todoly.app.TextBasedUserInterface;
import todoly.services.FileRepositoryService;
import todoly.services.TaskService;

public class ToDoLy {
	
	public static void main(String[] args) {
		// cli = Command Line Interface
		TextBasedUserInterface cli = new TextBasedUserInterface(
											new TaskService(
												new FileRepositoryService()
											)
									  );
		
		do {
			cli.run();
		}while(cli.isRunning());
		
		cli.save();
	}
}
