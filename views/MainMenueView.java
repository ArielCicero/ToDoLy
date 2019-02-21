package todoly.views;

public class MainMenueView extends View {
	
	private String taskAmount;
	private String taskDoneAmount;
	
	public MainMenueView(String taskAmount, String taskDoneAmount){
		this.taskAmount = taskAmount;
		this.taskDoneAmount = taskDoneAmount;
	}
	
	@Override
	public void display() {
		printErrorMessage();
		System.out.println(">> Welcome to ToDoLy");
		System.out.println(">> You have "+taskAmount+" tasks todo and "+taskDoneAmount+" tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
	}
}
