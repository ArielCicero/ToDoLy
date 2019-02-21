package todoly.views;

public class ListTasksMenueView extends View {

	@Override
	public void display() {
		printErrorMessage();
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List order by date");
		System.out.println(">> (2) Show Task List filtered by project)");
		System.out.println(">> (3) Come back to Main Menue");
		System.out.print(">> ");
	}

}
