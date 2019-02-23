package todoly.model;

import java.util.Date;

public class Task implements Comparable<Task>{

	private String taskId;
    private String name;
    private String description;
    private Date dueDate;
    private boolean isDone;
    private Integer projectId;
    
    
    
	@Override
	public int compareTo(Task otherTask) {
		return dueDate.compareTo(otherTask.getDueDate());
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
