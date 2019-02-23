package todoly.views;

import java.util.List;

import todoly.model.Project;

public class ListProjectsMenuView extends View {
	
	List<Project> projects;
	
	public ListProjectsMenuView(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public void display() {
		printErrorMessage();
		System.out.println("################################################");
		if(projects != null) {
			for (Project project : projects) {
				System.out.println(project);
			}
		}
		else {
			System.out.println(">> There are no projects");
		}
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List filtered by project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Update Task (by ID)");
		System.out.println(">> (4) Remove Task (by ID)");
		System.out.println(">> (5) Save and Quit");
		System.out.print(">> ");
	}

}
