package todoly.views.menus;

public class MainMenuView extends MenuView {
	String tasksAmount;
	String tasksDoneAmount;
	public MainMenuView(String tasksAmount, String tasksDoneAmount) {
		this.tasksAmount = tasksAmount;
		this.tasksDoneAmount = tasksDoneAmount;
	}

	
	@Override
	public void printMenu(String errorMessage) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> Welcome to ToDoLy");
		System.out.println(">> You have "+tasksAmount+" tasks todo and "+tasksDoneAmount+" tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
}