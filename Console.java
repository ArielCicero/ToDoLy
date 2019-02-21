package todoly;

import java.util.Scanner;

public class Console {
	
	private Scanner scanner;
	private String input;
	
	public Console() {
		scanner = new Scanner(System.in);
	}

	public void read() {
		input = scanner.nextLine();
	}

	public String getInput() {
		return input;
	}

}
