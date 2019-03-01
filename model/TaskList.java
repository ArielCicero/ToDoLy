package todoly.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;

public class TaskList implements TaskListInterface{
	private Map<Integer,Task> tasks = new HashMap<>();
	private Map<Integer,Project> projects = new HashMap<>();

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
	public void addTask(Task newTask) {
		Integer id = tasks.values().size()+1;
		// a new task can not have an id already
		if(newTask.getId() == null) {
			// if the project is new as well
			Integer projectIdOfNewTask = newTask.getProject().getId();
			if(projectIdOfNewTask == null) {
				newTask.setId(id);
				tasks.put(id, newTask);
				id = projects.values().size()+1;
				
				Project newProject = newTask.getProject();
				newProject.setId(id);
				newProject.addTask(newTask);
				projects.put(id, newProject);
			}
			//else if project does not contains a task with this name
			else if(!projects.get(projectIdOfNewTask).getTasks().contains(newTask)){
				newTask.setId(id);
				tasks.put(id, newTask);
				projects.get(projectIdOfNewTask).addTask(newTask);
			}
			else {
				throw new ToDoLyException("The Task already exist.");
			}
		}
		else {
			throw new ToDoLyException("The Task already exist.");
		}
		
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

	@Override
	public Project getProject(Integer userInput) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
