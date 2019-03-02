package todoly.views;

public abstract class View {
	public String tasksAmount;
	public String tasksDoneAmount;
	
	public View(String tasksAmount, String tasksDoneAmount) {
		this.tasksAmount = tasksAmount;
		this.tasksDoneAmount = tasksDoneAmount;
	}
	
	protected void printLineSeparator() {
		System.out.println("###########################################"
						  +"############################################");
	}
	
	protected void printErrorMessage(String errorMessage) {
		if(errorMessage != null) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("ERROR");
			System.out.println("!!!!!" + errorMessage);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");		
		}
	}
	
	public void printMenu(String errorMessage) {
		printErrorMessage(errorMessage);
		printLineSeparator();
		System.out.println(">> You have "+tasksAmount+" tasks todo and "+tasksDoneAmount+" tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List Ordered by Due Date");
		System.out.println(">> (2) Show Task List Filtered by Project");
		System.out.println(">> (3) Add New Task");
		System.out.println(">> (4) Update Task Status");
		System.out.println(">> (5) Update Task Title");
		System.out.println(">> (6) Update Task Due Date");
		System.out.println(">> (7) Update Task-project Name");
		System.out.println(">> (8) Remove Task");
		System.out.println(">> (9) Save and Quit");
		System.out.print(">> ");
	}
}
