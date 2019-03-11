package todoly.model;

import java.io.Serializable;

import todoly.util.IsNumeric;

public class Task implements Comparable<Task>, Serializable {
    private static final long serialVersionUID = 8663464221335074339L;
    
    private Integer id;
    private String title;
    private Date dueDate;
    private boolean isDone = false;
    private Project project;
    
    Task(Integer id, String title, Date dueDate, Project project) {
        this.id = id;
        this.setTitle(title);
        this.dueDate = dueDate;
        this.project = project;
    }

    @Override
    public int compareTo(Task otherTask) {
        return -1 * title.compareTo(otherTask.title);
    }


    public Date getDueDate() {
        return dueDate;
    }


    void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public Integer getId() {
        return id;
    }


    //package visibility
    void setId(Integer taskId) {
        this.id = taskId;
    }


    public String getTitle() {
        return title;
    }


    void setTitle(String title) {
        this.title = validateTitle(title);
    }
    
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

    public boolean isDone() {
        return isDone;
    }


    void setStatus(boolean status) {
        isDone = status;
    }


    public Project getProject() {
        return project;
    }


    void setProject(Project project) {
        this.project = project;
    }


    @Override
    public String toString() {  
        // The next code commented it's a different Task displaying format 
        
//      return  "Task [" + id + "]    " +
//              "Due Date: " + dueDate + "    " +
//              "Title: " + title + "    " +
//              "Status: " + (isDone? "Done": "To do") + "    " +
//              "Project: " + project;
        
        return  "Task [" + id + "] " + 
                title + "\n" +
                "\t Due Date: " + dueDate + 
                "\t Status: " + (isDone? "Done": "To Do") +
                "\t Project: " + project;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
