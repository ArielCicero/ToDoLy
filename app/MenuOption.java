package todoly.app;

/**
 * The <code>MenuOption</code> enum represents the possible menu
 * options that occurs in the <code>ToDoLy</code> App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public enum MenuOption {
    MAIN_MENUE,
        TASK_LISTING_MENU,
            LIST_TASKS_BY_DUE_DATE,
            LIST_TASKS_FILTERED_BY_PROJECT,
        ADD_NEW_TASK,
        TASK_EDITION_MENU,
            UPDATE_TASK_STATUS,
            UPDATE_TASK_TITLE,
            UPDATE_TASK_DUE_DATE,
            UPDATE_TASK_PROJECT_NAME,
            REMOVE_TASK,
        SAVE_AND_QUIT;
}
