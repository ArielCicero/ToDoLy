package todoly.controllers;

import java.util.HashMap;
import java.util.List;

import todoly.enums.Context;
import todoly.model.Task;

public class FilterByProjectController extends ViewController {

	
	public FilterByProjectController(List<Task> tasks) {
		//view = new FilterByProjectView(tasks);
	}

	@SuppressWarnings("serial")
	@Override
	protected void setvalidMenuOptions() {
		validMenuOptions = new HashMap<>() {{
			put("1", Context.ORDER_BY_DUE_DATE);
			put("2", Context.NEW_TASK);
			put("3", Context.UPDATE_TASK);
			put("3", Context.REMOVE_TASK);
			put("4", Context.SAVE_AND_QUIT);
		}};		
	}

}
