package todoly.views;

/**
 * The <code>TaskEditionMenuView</code> class extends <code>View</code> class and
 * overridesits printMenu method offering options related with editing the tasks
 * of the <code>ToDoLy</code> text based App.
 * @see View
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class TaskEditionMenuView extends View {
    /**
     * Prints the menu related with the options to edit tasks.
     * Remove a task or Update the next attribues of a task:
     * Status, Title, Due Date, Project Name.
     */
    @Override
    public void printMenu(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Update Task Status");
        System.out.println(">> (2) Update Task Title");
        System.out.println(">> (3) Update Task Due Date");
        System.out.println(">> (4) Update Task's Project Name");
        System.out.println(">> (5) Remove Task");
        System.out.print(">> ");
    }
}
