package todoly;

import java.util.HashMap;
import java.util.Map;

import todoly.app.TextBasedUserInterface;
import todoly.exceptions.DateException;
import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.services.FileRepositoryService;
import todoly.services.TaskService;

public class ToDoLy {
	
	public static void main(String[] args) {
		
		Map<Integer,Task> tasks = new HashMap<>();
		try {
			tasks.put(1, new Task("1", "titulo1", new Date("2012-7-1"), false, new Project("1","project1")));
			tasks.put(2, new Task("2", "titulo2", new Date("2018-7-1"), false, new Project("1","project1")));
			tasks.put(3, new Task("3", "titulo33333", new Date("2010-7-1"), false, new Project("2","project2")));
		} catch (DateException e) {
			e.printStackTrace();
		}
		
		Map<Integer,Project> projects = new HashMap<>();
		projects.put(1,new Project("1","project1"));
		projects.put(2,new Project("2","project2"));
		
		
		
		// cli = Command Line Interface
		TextBasedUserInterface cli = new TextBasedUserInterface(
											new TaskService(
												new FileRepositoryService(tasks,projects)
											)
									  );
		
		do {
			cli.run();
		}while(cli.isRunning());
		
		cli.save();
	}
}
