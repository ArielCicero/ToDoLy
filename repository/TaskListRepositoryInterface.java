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
    
    /**
     * The general contract of the method <code>loadTaskList</code> is that any class
     * that implements the <code>TaskListRepositoryInterface</code> interface must
     * implement a functionality load an object with TaskListInterface implementation
     * or the data needed to create one with the same status that it had when saved.
     * @see TaskListInterface
     * @return TaskListInterface
     */
    TaskListInterface loadTaskList();
    
    /**
     * The general contract of the method <code>saveTaskList</code> is that any class
     * that implements the <code>TaskListRepositoryInterface</code> interface must
     * implement a functionality to save an object with TaskListInterface implementation
     * or to save the data needed to create one with the same status when loaded.
     * @see TaskListInterface
     * @param TaskListInterface taskList
     */
    void saveTaskList(TaskListInterface taskList);
    
}
