package todoly.views;

public class ListingMenuView extends View {
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
