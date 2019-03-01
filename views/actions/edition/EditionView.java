package todoly.views.actions.edition;

import java.util.List;

import todoly.views.View;

public abstract class EditionView extends View {
	public abstract void printList(String errorMessage, List<String> tasks);
	public abstract void askForTaskId(String errorMessage, List<String> tasks);
	public abstract void printMenu(String errorMessage);
	public abstract void printConfirmation(String task);
}
