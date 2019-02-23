package todoly.model;

public class Project implements Comparable<Project>{
	private Integer projectId;
    private String projectName;
    
	@Override
	public int compareTo(Project otherProject) {
		return projectId.compareTo(otherProject.getProjectId());
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
