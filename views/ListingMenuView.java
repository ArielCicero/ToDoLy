package todoly.views;

/**
 * The <code>ListingMenuView</code> class extends <code>View</code> class and
 * overrides its printMenu method offering options related with listing the
 * tasks of the <code>ToDoLy</code> text based App.
 * @see View
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class ListingMenuView extends View {
    /**
     * Prints the menu related with the options to list tasks (ordering by due date
     * or filtering by project)
     */
    @Override
    public void printMenu(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List Ordered by Due Date");
        System.out.println(">> (2) Show Task List Filtered by Project");
        System.out.print(">> ");
    }
}
