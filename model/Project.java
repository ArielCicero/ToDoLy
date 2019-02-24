package todoly.model;

public class Project implements Comparable<Project>{
	private String projectId;
    private String projectName;
    
	public Project(String projectId, String projectName) {
		this(projectName);
		this.projectId = projectId;
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public int compareTo(Project otherProject) {
		return projectId.compareTo(otherProject.getProjectId());
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
}
