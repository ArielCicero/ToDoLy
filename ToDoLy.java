package todoly;

import todoly.services.FileRepositoryService;
import todoly.services.TaskService;

public class ToDoLy {
	
	public static void main(String[] args) {
		TextBasedInterface textBasedInterface = new TextBasedInterface(
											new TaskService(
													new FileRepositoryService()
												)
										);
		
		do {
			textBasedInterface.run();
		}while(textBasedInterface.isRunning());
		
		textBasedInterface.save();
	}
}
