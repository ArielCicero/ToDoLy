package todoly.repository;

import todoly.interfaces.TaskListInterface;
import todoly.interfaces.TaskListRepositoryInterface;
import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.model.TaskList;

public class FileRepository implements TaskListRepositoryInterface {

	public FileRepository(String path) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TaskListInterface loadTaskList() {
		Task t1 =  new Task("titulo1", new Date("2012-7-1"), false, new Project("project1"));
		Task t2 =  new Task("titulo2", new Date("2018-7-1"), false, new Project("project1"));
		Task t3 =  new Task("titulo33333", new Date("2010-7-1"), false, new Project("project2"));
		
		TaskList taskList = new TaskList();
		taskList.addTask(t1);
		taskList.addTask(t2);
		taskList.addTask(t3);
		
		return taskList;
	}

	@Override
	public void saveTaskList(TaskListInterface taskList) {
		// TODO Auto-generated method stub
		
	}


}
