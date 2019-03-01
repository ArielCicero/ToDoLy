package todoly.views.actions.edition;

import java.util.List;

import todoly.views.View;

public abstract class EditionView extends View {
	public abstract void printConfirmation(String task);
	
	public void printList(String errorMessage, List<String> list) {
		printLineSeparator();
		for (String value : list) {
			System.out.println(value);
		}
	}

	public void askForTaskId(String errorMessage, List<String> list) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> Please intoduce one ID from the list");
		System.out.print(">> ");
	}
}
