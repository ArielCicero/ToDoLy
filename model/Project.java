package todoly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todoly.util.IsNumeric;

public class Project implements Comparable<Project>, Serializable {
    private static final long serialVersionUID = -4489076521323526969L;
    private Integer id;
    private String name;
    private Map<Integer, Task> tasks = new HashMap<>();
    
    public List<Task> getTasks(){
        return new ArrayList<Task>(tasks.values());
    }

    void addTask(Task task) {
        tasks.put(task.getId(), task);
    }
    
    void removeTask(Task task) {
        tasks.remove(task.getId());
    }
    
    public Project(String name) {
        setName(name);
    }

    @Override
    public int compareTo(Project otherProject) {
        return -1 * name.compareTo(otherProject.getName());
    }

    public Integer getId() {
        return id;
    }

    //package visibility
    void setId(Integer projectId) {
        this.id = projectId;
    }

    public String getName() {
        return name;
    }

    //package visibility
    void setName(String name) {
        this.name = validateName(name);
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

    public static String validateName(String name) {
        if(name == null) {
            throw new BusinessModelException("The Project Name can not be null");
        }
        name = name.trim();
        if(name == "") {
            throw new BusinessModelException("The Project Name can not be empty");
        }
        if(name.length() < 2) {
            throw new BusinessModelException("The Project Name has to have at least 2 chars");
        }
        if(IsNumeric.check(name)) {
            throw new BusinessModelException("The Project Name can not be a number");
        }
        if(IsNumeric.check(name.replace(",","."))) {
            throw new BusinessModelException("The Project Name can not be a number");
        }
        return name;
    }

    public boolean hasTaskTitle(String taskTitle) {
        return tasks.values().stream().anyMatch(t->t.getTitle().equals(taskTitle));
    }
}
