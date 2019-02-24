package todoly.model;


public class Task implements Comparable<Task>{

	private String taskId;
    private String title;
    private Date dueDate;
    private boolean isDone;
    private Project project;
    
    
    public Task(String taskId, String title, Date dueDate, boolean isDone, Project project) {
    	this.taskId = taskId;
    	this.title = title;
    	this.dueDate = dueDate;
    	this.isDone = isDone;
    	this.project = project;
    }
    
    
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


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isDone() {
		return isDone;
	}


	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	@Override
	public String toString() {	
		return	"Task [" + taskId + "] " +
				"Due Date: " + dueDate + " " +
				"Title: " + title + " " +
				"Done: " + (isDone? "yes": "not yet") + " " +
				"Project: " + project;
	}

}
