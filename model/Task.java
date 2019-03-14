package todoly.model;

import java.io.Serializable;

import todoly.util.IsNumeric;

/**
 * The <code>Task</code> class belongs to the model of the <code>ToDoLy</code>
 * App, and implements the functionality needed by the <code>ToDoLy</code> App to
 * manage tasks.
 * The <code>Task</code> class implements the <code>Comparable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to order its tasks by
 * task title.
 * The <code>Task</code> class implements the <code>Serializable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to save its status in
 * a file.
 * The <code>Task</code> class throws <code>BusinessModelException</code>.
 * Since the way to update a task should be centralised in the object that implements
 * a TaskListInterface interface, that object has to be placed in the same package
 * because the mutators methods (setters) of the <code>Task</code> class has a
 * default/package access modifier to encapsulate the visibility and separate concerns.
 *
 * @see Serializable
 * @see Comparable
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class Task implements Comparable<Task>, Serializable {
    private static final long serialVersionUID = 8663464221335074339L;
    
    private Integer id;
    private String title;
    private Date dueDate;
    private boolean isDone = false;
    private Project project;
    
    /**
     * Constructor of the Task class.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param id
     * @param title
     * @param dueDate
     * @param project
     */
    Task(Integer id, String title, Date dueDate, Project project) {
        this.id = id;
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.project = project;
    }

    /**
     * Compares this project to another project.
     * @param otherTask
     * @return int representing the comparator value, negative if less,
     * positive if greater
     */
    @Override
    public int compareTo(Task otherTask) {
        return -1 * title.compareTo(otherTask.title);
    }

    /**
     * @return Date object type representing the task due date.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the task due date.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param dueDate
     */
    void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return Integer representing the task ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the task ID.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param Integer taskId
     */
    void setId(Integer taskId) {
        this.id = taskId;
    }

    /**
     * @return String representing the title of the task
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the task title.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param String representing the task title
     */
    void setTitle(String title) {
        this.title = validateTitle(title);
    }
    
    /**
     * @param title representing the title to validate
     * @return String object type representing the title validated and trimmed
     * @see String#trim()
     */
    public static String validateTitle(String title) {
        if(title == null) {
            throw new BusinessModelException("The Task Title can not be null");
        }
        title = title.trim();
        if(title == "") {
            throw new BusinessModelException("The Task Title can not be empty");
        }
        if(title.length() < 2) {
            throw new BusinessModelException("The Task Title has to have at least 2 chars");
        }
        if(IsNumeric.check(title)) {
            throw new BusinessModelException("The Task Title can not be a number");
        }
        if(IsNumeric.check(title.replace(",","."))) {
            throw new BusinessModelException("The Task Title can not be a number");
        }
        return title;
    }

    /**
     * @return true if this task is done; false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Sets the status of the task.
     * True if this task is done; false otherwise.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param boolean status
     */
    void setStatus(boolean status) {
        isDone = status;
    }

    /**
     * @return Project type object representing the project to which the task belongs.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the project for the task.
     * It has package visibility to restrict the access only for the TaskList class.
     * @param project object type Project representing the project to which the task belongs.
     */
    void setProject(Project project) {
        this.project = project;
    }

    /**
     * Outputs this task as a String.
     * @return String representing this task
     */
    @Override
    public String toString() {  
        return  "Task [" + id + "] " + 
                title + "\n" +
                "\t Due Date: " + dueDate + 
                "\t Status: " + (isDone? "Done": "To Do") +
                "\t Project: " + project;
    }

    /**
     * @return a hash code value for the task object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    /**
     * Indicates whether some other task is "equal to" this one.
     * @param obj the reference object with which to compare.
     * @return true if this task is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (project == null) {
            if (other.project != null)
                return false;
        } else if (!project.equals(other.project))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    } 
}
