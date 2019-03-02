package todoly.views.menus;

import todoly.views.View;

public class ListingMenuView extends View{
    
    public ListingMenuView(String tasksAmount, String tasksDoneAmount) {
        super(tasksAmount,tasksDoneAmount);
    }

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
