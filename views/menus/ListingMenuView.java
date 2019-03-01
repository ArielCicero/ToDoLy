package todoly.views.menus;

public class ListingMenuView extends MenuView {

	@Override
	public void printMenu(String errorMessage) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List Ordered By Due date or project)");
		System.out.println(">> (2) Show Task List filtered by project)");
		System.out.print(">> ");
	}

}
