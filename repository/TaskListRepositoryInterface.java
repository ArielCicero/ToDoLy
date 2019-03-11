package todoly.repository;

import todoly.model.TaskListInterface;

public interface TaskListRepositoryInterface {
    
    TaskListInterface loadTaskList();
    
    void saveTaskList(TaskListInterface taskList);
    
}
