package todoly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todoly.util.IsNumeric;

/**
 * The <code>Project</code> class belongs to the model of the <code>ToDoLy</code>
 * App, and implements the functionality needed by the <code>ToDoLy</code> App to
 * manage projects.
 * The <code>Project</code> class implements the <code>Comparable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to order its tasks by
 * project name.
 * The <code>Project</code> class implements the <code>Serializable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to save its status in
 * a file.
 * The <code>Project</code> class throws <code>BusinessModelException</code>.
 * Since the way to update a project should be centralised in the object that implements
 * a TaskListInterface interface, that object has to be placed in the same package
 * because the mutators methods (setters) of the <code>Project</code> class has a
 * default/package access modifier to encapsulate the visibility and separate concerns.
 * @see Serializable
 * @see Comparable
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class Project implements Comparable<Project>, Serializable {
    private static final long serialVersionUID = -4489076521323526969L;
    private Integer id;
    private String name;
    private Map<Integer, Task> tasks = new HashMap<>();
    
    public Project(String name) {
        setName(name);
    }
    
    public List<Task> getTasks(){
        return new ArrayList<Task>(tasks.values());
    }
    
    // package visibility
    void addTask(Task task) {
        tasks.put(task.getId(), task);
    }
    
    // package visibility
    void removeTask(Task task) {
        tasks.remove(task.getId());
    }

    @Override
    public int compareTo(Project otherProject) {
        return -1 * name.compareTo(otherProject.getName());
    }

    public Integer getId() {
        return id;
    }

    // package visibility
    void setId(Integer projectId) {
        this.id = projectId;
    }

    public String getName() {
        return name;
    }

    // package visibility
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

    /*
     * @param name representing the name to validate
     * @return String object type representing the name validated and trimmed
     * @see String#trim()
     */
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
