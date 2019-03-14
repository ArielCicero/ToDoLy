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
    
    /**
     * Prints a line to separate content displayed.
     */
    protected void printLineSeparator() {
        System.out.println("###########################################" +
                           "############################################");
    }
    
    /**
     * Prints the error message when occurs.
     * @param errorMessage
     */
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
    
    /**
     * Prints a menu which has all the possible options to be performed by the App.
     * @param errorMessage
     */
    public void printMenu(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> You have " + tasksToDoAmount + " tasks todo and " + tasksDoneAmount +
                           " tasks are done!");
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
    
    /**
     * Prints a list of strings.
     * @param List<String> object type representing the list to be displayed
     */
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

    /**
     * Prints a message to the user asking for a task ID
     * @param errorMessage
     * @param List<String> object type representing the list to be displayed
     */
    public void askForTaskId(String errorMessage, List<String> list) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write one of the listed Task's ID");
        System.out.print(">> ");
    }
    
    /**
     * Prints a message to the user asking for a project ID
     * @param errorMessage
     */
    public void askForProjectId(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write one of the listed Project's ID");
        System.out.print(">> ");
    }
    
    /**
     * Prints a confirmation to the user to inform the result of an operation.
     * @param message to display
     * @param element used in the performed operation.
     */
    public void printConfirmation(String message, String element) {
        printLineSeparator();
        System.out.println("!! " + message);
        if(element != null) {
            printLineSeparator();
            System.out.println(element);
        }
    }
       
    /**
     * Prints a message to the user asking for a project ID and giving the option
     * to insert 0 if the user prefers to write a project name instead.
     * @param errorMessage
     */
    public void askForProjectIdOrZero(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Pick one of the listed project IDs or " +
                           "0 if you want to write a new Project Name");
        System.out.print(">> ");
        
    }

    /**
     * Prints a message to the user asking for a project name.
     * @param errorMessage
     */
    public void askForProjectName(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Project Name (\"ön\" and \"<3\" are valid names)");
        System.out.print(">> ");
    }

    /**
     * Prints a message to the user asking for the due date of a task.
     * @param errorMessage
     */
    public void askForDueDate(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Due Date (date format YYYY-MM-DD = \"2012-7-1\")");
        System.out.print(">> ");
    }

    /**
     * Prints a message to the user asking for the title of a task.
     * @param errorMessage
     */
    public void askForTaskTitle(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write the Task Title (2 chars min)");
        System.out.print(">> ");
    }

    /**
     * Prints a message to the user asking for the status of a task.
     * @param errorMessage
     */
    public void askForNewStatus(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Write (1) to mark it as Done or (0) to mark it as a task To Do");
        System.out.print(">> ");
    }
    
    /**
     * Sets the a amount of task to do that will be displayed by the printMenu method
     * @param String representing the amount of tasks to do
     */
    public void setTasksToDoAmount(String tasksToDoAmount) {
        this.tasksToDoAmount = tasksToDoAmount;
    }

    /**
     * Sets the a amount of task done that will be displayed by the printMenu method
     * @param String representing the amount of tasks done
     */
    public void setTasksDoneAmount(String tasksDoneAmount) {
        this.tasksDoneAmount = tasksDoneAmount;
    }
    
    /**
     * Message displayed when closing the application.
     */

    public static void goodbyeMessage() {
        System.out.println("===========================================" +
                           "============================================");
        System.out.println(">> Thanks For Ussing The ToDoLy App :)");
        System.out.println("===========================================" +
                           "============================================");  
    }
}
