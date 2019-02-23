package todoly.controllers;

import java.util.HashMap;

import todoly.enums.Context;
import todoly.views.ListTasksMenueView;

public class ListTasksMenueController extends ViewController {

	ListTasksMenueController() {
		view = new ListTasksMenueView();
		setvalidMenuOptions();
	}

	@SuppressWarnings("serial")
	@Override
	protected void setvalidMenuOptions() {
		validMenuOptions = new HashMap<>() {{
			put("1", Context.ORDER_BY_DUE_DATE);
			put("2", Context.FILTER_BY_PROJECT);
			put("3", Context.MAIN_MENUE);
		}};
	}

}
