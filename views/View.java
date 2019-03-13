package todoly.views;

import java.util.List;

/**
 * The <code>View</code> abstract class is general-purpose class that
 * groups common processes needed in the <code>ToDoLy</code> text based
 * App in order to display information and communicate with the user.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class View {
    public String tasksToDoAmount;
    public String tasksDoneAmount;
    
    protected void printLineSeparator() {
        System.out.println("###########################################" +
                           "############################################");
    }
    
    protected void printErrorMessage(String errorMessage) {
        if(errorMessage != null) {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *" +
                               " * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("ERROR");
            System.out.println("!!!!!" + errorMessage);
            System.out.println("* * * * * * * * * * * * * * * * * * * * * *" +
                               " * * * * * * * * * * * * * * * * * * * * * *");      
        }
    }
    
    public void printMenu(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> You have "+tasksToDoAmount+" tasks todo and "+tasksDoneAmount+" tasks are done!");
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
    
    public void printList(List<String> list) {
        printLineSeparator();
        if(list != null && !list.isEmpty()) {
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
        System.out.println(">> Write one of the listed Task's ID");
        System.out.print(">> ");
    }
    
    public void askForProjectId(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write one of the listed Project's ID");
        System.out.print(">> ");
    }
    
    public void printConfirmation(String message, String element) {
        printLineSeparator();
        System.out.println("!! " + message);
        if(element != null) {
            printLineSeparator();
            System.out.println(element);
        }
    }
        
    public void askForProjectIdOrZero(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Pick one of the listed project IDs or " +
                           "0 if you want to write a new Project Name");
        System.out.print(">> ");
        
    }

    public void askForProjectName(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Project Name (\"ön\" and \"<3\" are valid names)");
        System.out.print(">> ");
    }

    public void askForDueDate(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Due Date (date format YYYY-MM-DD = \"2012-7-1\")");
        System.out.print(">> ");
    }

    public void askForTaskTitle(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Task Title (2 chars min)");
        System.out.print(">> ");
    }

    public void askForNewStatus(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write (1) to mark it as Done or (0) to mark it as a task To Do");
        System.out.print(">> ");
    }
    
    public void setTasksToDoAmount(String tasksAmount) {
        this.tasksToDoAmount = tasksAmount;
    }

    public void setTasksDoneAmount(String tasksDoneAmount) {
        this.tasksDoneAmount = tasksDoneAmount;
    }
}
