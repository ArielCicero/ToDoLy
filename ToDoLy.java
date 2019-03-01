package todoly;

import todoly.app.TextBasedApp;
import todoly.repository.FileRepository;

public class ToDoLy {
	
	public static void main(String[] args) {

		String path = "ToDoLy.ser";
		Runnable app = new TextBasedApp(
								new FileRepository(path)
						);
		
		app.run();
	}
}
