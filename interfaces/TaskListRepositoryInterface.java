package todoly.interfaces;

public interface TaskListRepositoryInterface {
    
    TaskListInterface loadTaskList();
    
    void saveTaskList(TaskListInterface taskList);
    
}
