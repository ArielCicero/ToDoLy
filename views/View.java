package todoly.views;

public abstract class View {
	
	protected String errorMessage;

	public abstract void display();

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void printErrorMessage() {
		if(errorMessage != null) {
			System.out.println("**********************************************");
			System.out.println(errorMessage);
			System.out.println("**********************************************");
		}
	}

}
