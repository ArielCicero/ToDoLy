package todoly.util;

import java.util.Comparator;

import todoly.model.Task;

/**
 * The <code>SortByDueDate</code> class is a helper class used by the 
 * <code>ToDoLy</code> App.
 * The <code>SortByDueDate</code> class implements <code>Comparator</code>
 * interface with the goal of give the <code>ToDoLy</code> App the ability
 * to sort tasks by their due date.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class SortByDueDate implements Comparator<Task> {
    /**
     * Compares its two arguments for order. Returns a negative integer, zero,
     * or a positive integer as the first argument is less than, equal to, or
     * greater than the second.
     * @return int representing the result of the comparison
     */
    @Override
    public int compare(Task t1, Task t2) { 
        return t1.getDueDate().compareTo(t2.getDueDate()); 
    }
}
