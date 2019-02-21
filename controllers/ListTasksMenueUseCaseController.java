package todoly.controllers;

import java.util.HashMap;

import todoly.enums.Context;
import todoly.views.ListTasksMenueView;

public class ListTasksMenueUseCaseController extends MenueUseCaseController {

	@SuppressWarnings("serial")
	ListTasksMenueUseCaseController() {
		view = new ListTasksMenueView();
		validMenuOptions = new HashMap<>() {{
			put("1", Context.ORDER_BY_DUE_DATE);
			put("2", Context.FILTER_BY_PROJECT);
			put("3", Context.MAIN_MENUE);
		}};
	}

}
