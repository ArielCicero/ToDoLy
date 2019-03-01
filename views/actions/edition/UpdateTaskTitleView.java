package todoly.views.actions.edition;

public class UpdateTaskTitleView extends EditionView {

	@Override
	public void printConfirmation(String task) {
		System.out.println(">> The Task Has Been Updated Successfully");
		System.out.println(task);
	}

	public void askNewTitle(String errorMessage) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> Write Task Title");
		System.out.print(">> ");
	}

}
