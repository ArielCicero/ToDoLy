package todoly.views;

import java.util.List;

import todoly.model.Task;

public class OrderByDateView extends View {
	
	private List<Task> tasks;
	public OrderByDateView(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public void display() {
		printErrorMessage();
		System.out.println("################################################");
		if(tasks != null) {
			for (Task task : tasks) {
				System.out.println(task);
			}
		}
		else {
			System.out.println(">> There is no tasks");
		}
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List filtered by project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}

}
