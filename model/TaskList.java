package todoly.model;

import java.util.List;

import todoly.interfaces.TaskListInterface;

public class TaskList implements TaskListInterface{

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Task> getTasksFilteredByProject(String taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTask(String taskId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTasksAmount() {
		// can not be null
		return 0;
	}

	@Override
	public int getTasksDoneAmount() {
		// can not be null
		return 0;
	}

	@Override
	public Task getTask(String taskId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
