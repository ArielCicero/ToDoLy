package todoly.views.actions.edition;

import java.util.List;

import todoly.views.View;

public class ActionView extends View {
	
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
	
	public void askForInput(String errorMessage, String request) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> Write " + request);
		System.out.print(">> ");
	}
	
	public void printConfirmation(String message, String item) {
		System.out.println(">> " + message);
		System.out.println(item);
	}
}
