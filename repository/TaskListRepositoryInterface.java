package todoly.repository;

import todoly.model.TaskListInterface;

/**
 * The <code>TaskListRepositoryInterface</code> interface should be implemented
 * by any class whose instances are intended to implement the functionality needed
 * to save the status of the <code>ToDoLy</code> App.
 *
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public interface TaskListRepositoryInterface {
    
    TaskListInterface loadTaskList();
    
    void saveTaskList(TaskListInterface taskList);
    
}
