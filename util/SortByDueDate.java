package todoly.util;

import java.util.Comparator;

import todoly.model.Task;

/**
 * The <code>SortByDueDate</code> class is a helper class used by the 
 * <code>ToDoLy</code> App.
 * The <code>SortByDueDate</code> class implements <code>Comparator</code>
 * interface with the goal of give the <code>ToDoLy</code> app the hability
 * to sort tasks by their due date.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class SortByDueDate implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) { 
        return t1.getDueDate().compareTo(t2.getDueDate()); 
    }
}
