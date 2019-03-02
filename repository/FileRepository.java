package todoly.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.interfaces.TaskListRepositoryInterface;
import todoly.model.TaskList;

public class FileRepository implements TaskListRepositoryInterface {
    private String path;
    public FileRepository(String path) {
        this.path = path;
    }

    @Override
    public TaskListInterface loadTaskList() {
        TaskList taskList = null;
//        TaskList taskList = new TaskList();
//        Task t1 =  new Task("b titulo1", new Date("2012-7-1"), false, new Project("b project1"));
//        Task t2 =  new Task("c titulo2", new Date("2018-7-1"), false, new Project("b project1"));
//        Task t3 =  new Task("a titulo33333", new Date("2010-7-1"), false, new Project("a project2"));
//        taskList.addTask(t1);
//        taskList.addTask(t2);
//        taskList.addTask(t3);

        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn);){  
            taskList = (TaskList) in.readObject();
         } catch (IOException e) {
             throw new ToDoLyException(e.getMessage());
         } catch (ClassNotFoundException e2) {
             throw new ToDoLyException(e2.getMessage());
         }

        return taskList;
    }

    @Override
    public void saveTaskList(TaskListInterface taskList) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);){  
            out.writeObject(taskList);
         } catch (IOException e) {
             throw new ToDoLyException(e.getMessage());
         }
    }


}
