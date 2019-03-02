package todoly.model;

import java.util.HashSet;
import java.util.Set;

import todoly.exceptions.ToDoLyException;

public class Project implements Comparable<Project>{
	private Integer id;
    private String name;
    private Set<Task> tasks = new HashSet<>();
    
    Set<Task> getTasks(){
    	return tasks;
    }
    
    void addTask(Task task) {
    	tasks.add(task);
    }
    
    void removeTask(Task task) {
    	tasks.remove(task);
    }
	
	public Project(String name) {
		setName(name);
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Project otherProject) {
		return -1 * name.compareTo(otherProject.getName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer projectId) {
		this.id = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.trim() == "" || name == null) {
			throw new ToDoLyException("The Project Name can not be empty");
		}
		if(name.trim().length() <= 2) {
			throw new ToDoLyException("The Project Name has to have at least 2 chars");
		}
		
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + id + "] " + name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
