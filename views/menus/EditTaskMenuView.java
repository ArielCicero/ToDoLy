package todoly.views.menus;

import todoly.views.View;

public class EditTaskMenuView extends View {
    
    public EditTaskMenuView(String tasksAmount, String tasksDoneAmount) {
        super(tasksAmount,tasksDoneAmount);
    }

    @Override
    public void printMenu(String errorMessage) {
        printErrorMessage(errorMessage);
        printLineSeparator();
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Update Task Status");
        System.out.println(">> (2) Update Task Title");
        System.out.println(">> (3) Update Task Due Date");
        System.out.println(">> (4) Update Task-project Name");
        System.out.println(">> (5) Remove Task");
        System.out.print(">> ");
    }

}
