package todoly.util.comparators;

import java.util.Comparator;

import todoly.model.Task;

public class SortByDueDate implements Comparator<Task>{
    @Override
    public int compare(Task t1, Task t2) 
    { 
        return t1.getDueDate().compareTo(t2.getDueDate()); 
    }
}
