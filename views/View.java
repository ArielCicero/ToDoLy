package todoly.views;

public abstract class View {
	protected void printLineSeparator() {
		System.out.println("###########################################"
						  +"############################################");
	}
	protected void printErrorMessage(String errorMessage) {
		if(errorMessage != null) {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("ERROR");
			System.out.println(errorMessage);
			System.out.println("* * * * * * * * * * * * * * * * * * * * * *"
							+ " * * * * * * * * * * * * * * * * * * * * * *");		
		}
	}
}
