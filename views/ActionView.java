package todoly.views;

import java.util.List;

public class ActionView extends View {
    
    public ActionView(String tasksAmount, String tasksDoneAmount) {
        super(tasksAmount,tasksDoneAmount);
    }
    
    public void printList(String errorMessage, List<String> list) {
        printLineSeparator();
        if(list != null) {
            for (String value : list) {
                System.out.println(value);
                System.out.println();
            }
        }
        else {
            System.out.println("There are no elements to list");
        }
    }

    public void askForTaskId(String errorMessage, List<String> list) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Intoduce one ID from the list");
        System.out.print(">> ");
    }
    
    public void askForInput(String errorMessage, String request) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write " + request);
        System.out.print(">> ");
    }
    
    public void printConfirmation(String message, String item) {
        printLineSeparator();
        System.out.println("!! " + message);
        printLineSeparator();
        System.out.println(item);
    }
}
