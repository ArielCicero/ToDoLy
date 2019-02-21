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
		for (Task task : tasks) {
			System.out.println(task);
		}
	}

}
