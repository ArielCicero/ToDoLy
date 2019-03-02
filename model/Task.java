package todoly.model;

import todoly.exceptions.ToDoLyException;

public class Task implements Comparable<Task>{

    private Integer id;
    private String title;
    private Date dueDate;
    private boolean isDone = false;
    private Project project;
    
    
    public Task() {
    }

    public Task(String title, Date dueDate, boolean isDone, Project project) {
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.project = project;
    }

    @Override
    public int compareTo(Task otherTask) {
        return -1 * title.compareTo(otherTask.title);
    }


    public Date getDueDate() {
        return dueDate;
    }


    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer taskId) {
        this.id = taskId;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        if(title.trim() == "" || title == null) {
            throw new ToDoLyException("The Task Title can not be empty");
        }
        if(title.trim().length() <= 2) {
            throw new ToDoLyException("The Task Title has to have at least 2 chars");
        }
        
        this.title = title.trim();
    }

    public boolean isDone() {
        return isDone;
    }


    public void setStatus(boolean isDone) {
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
