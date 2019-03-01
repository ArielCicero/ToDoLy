package todoly.model;

import java.util.List;

public class Project implements Comparable<Project>{
	private String projectId;
    private String projectName;
    private List<Task> tasks;
    
	public Project(String projectId, String projectName) {
		this(projectName);
		this.projectId = projectId;
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public int compareTo(Project otherProject) {
		return -1 * projectName.compareTo(otherProject.getProjectName());
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "[" + projectId + "] " + projectName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
