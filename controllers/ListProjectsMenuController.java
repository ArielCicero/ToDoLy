package todoly.controllers;

import java.util.List;

import todoly.enums.Context;
import todoly.model.Project;
import todoly.views.ListProjectsMenuView;

public class ListProjectsMenuController extends ViewController {

	public ListProjectsMenuController(List<Project> projects) {
		view = new ListProjectsMenuView(projects);
	}
	
	@Override
	public Context getContext(String input) {
		return Context.FILTER_BY_PROJECT;
	}

	@Override
	protected void setvalidMenuOptions() {
		validMenuOptions = null;		
	}

}
