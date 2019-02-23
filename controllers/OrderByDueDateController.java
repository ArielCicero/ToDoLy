package todoly.controllers;

import java.util.HashMap;
import java.util.List;

import todoly.enums.Context;
import todoly.model.Task;
import todoly.views.OrderByDateView;

public class OrderByDueDateController extends ViewController {
	
	public OrderByDueDateController(List<Task> tasks) {
		view = new OrderByDateView(tasks);
	}

	@SuppressWarnings("serial")
	@Override
	protected void setvalidMenuOptions() {
		validMenuOptions = new HashMap<>() {{
			put("1", Context.FILTER_BY_PROJECT);
			put("2", Context.NEW_TASK);
			put("3", Context.UPDATE_TASK);
			put("3", Context.REMOVE_TASK);
			put("4", Context.SAVE_AND_QUIT);
		}};		
	}

}
