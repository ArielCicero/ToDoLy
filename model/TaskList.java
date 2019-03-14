package todoly.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The <code>TaskList</code> class belongs to the model of the <code>ToDoLy</code>
 * App, and implements the functionality needed by the <code>ToDoLy</code> App to
 * manage a list of tasks and projects.
 * The <code>TaskList</code> class implements the <code>TaskListInterface</code>
 * interface to set a contract with the requirements given in the project specification
 * for the <code>ToDoLy</code> text base application.
 * The <code>TaskList</code> class implements the <code>Serializable</code> interface
 * in order to be possible for the <code>ToDoLy</code> App to save its status in
 * a file.
 * The <code>TaskList</code> class throws <code>BusinessModelException</code>.
 *
 * @see TaskListInterface
 * @see Serializable
 * 
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class TaskList implements TaskListInterface, Serializable {
    private static final long serialVersionUID = -6345286127117485787L;
    
    private Map<Integer,Task> tasks = new HashMap<>();
    private Map<Integer,Project> projects = new HashMap<>();
    private Integer projectId = 0;
    private Integer taskId = 0;

    /**
     * @return List<Task> representing a list of tasks
     */
    @Override
    public List<Task> getTasks() {
        return  new ArrayList<Task>(tasks.values());
    }

    /**
     * @return List<Project> representing a list of projects
     */
    @Override
    public List<Project> getProjects() {
        return new ArrayList<Project>(projects.values());
    }
    
    /**
     * @param Integer (the project ID)
     * @return the project corresponding to the specified ID,
     * or {@code null} if this id is not valid.
     * @see Project
     */
    @Override
    public Project getProject(Integer projectId) {
        return projects.get(projectId);
    }
    
    /**
     * @param Integer (the project name)
     * @return the project corresponding to the specified project name,
     * or {@code null} if this id is not valid.
     * @see Project
     */
    @Override
    public Project getProject(String projectName) {
        Project found = null;
        for (Project project : projects.values()) {
            if(project.getName().equals(projectName)) {
                found = project;
                break;
            }
        }
        return found;
    }
    
    /**
     * Adds a new task to the specified project if the title of the task is unique.
     * @throws BusinessModelException with the corresponding message when a task
     * can not be added.
     * @param project (the project of the task)
     * @param dueDate (the due date of the task)
     * @param taskTitle (the title of the task)
     * @return the task added
     */
    @Override
    public Task addTask(Project project, Date dueDate, String taskTitle) {
        Task newTask = null;
 
        Integer projectIdOfNewTask = project.getId();
        
        // if the project is new as well
        if(projectIdOfNewTask == null) {
            taskId++;
            newTask = new Task(taskId, taskTitle, dueDate, project);
            tasks.put(taskId, newTask);
            
            projectId++;
            project.setId(projectId);
            project.addTask(newTask);
            projects.put(projectId, project);
        }
        //else if project exists but does not contains a task with this title
        else if(!projects.get(projectIdOfNewTask).hasTaskTitle(taskTitle)){
            taskId++;
            newTask = new Task(taskId, taskTitle, dueDate, project);
            tasks.put(taskId, newTask);
            project.addTask(newTask);
        }
        else {
            throw new BusinessModelException("The Task Title already exist in this project");
        }
        
        return newTask;
    }

    /**
     * Removes a task from list of tasks.
     * If the project to which the task belongs to end ups empty after removing the task,
     * the project is also removed. It's not possible in this App to have empty projects.
     * @param task object type Task to be removed
     * @return the task removed
     */
    @Override
    public Task removeTask(Task task) {
        Task removedTask = tasks.remove(task.getId());
        if(removedTask != null) {
            Project projectOfRemovedTask = removedTask.getProject();
            projectOfRemovedTask.removeTask(removedTask);
            // if the task removed was the only one in that project the project will be removed
            // because it's not possible to have empty projects in this App
            if(projectOfRemovedTask.getTasks().isEmpty()) {
                projects.remove(projectOfRemovedTask.getId());
            }
        }
        return removedTask;
    }
    
    /**
     * @param Integer (the task ID)
     * @return the task corresponding to the specified ID,
     * or {@code null} if this id is not valid.
     * @see Task
     */
    @Override
    public Task getTask(Integer taskId) {
        return tasks.get(taskId);
    }

    /**
     * @return Integer representing the amount of tasks to do
     */
    @Override
    public Integer getTasksToDoAmount() {
        return tasks.values()
                .stream()
                .filter(x->!x.isDone())
                .collect(Collectors.toList())
                .size();
    }

    /**
     * @return Integer representing the amount of tasks done
     */
    @Override
    public Integer getTasksDoneAmount() {
        return tasks.values()
                    .stream()
                    .filter(x->x.isDone())
                    .collect(Collectors.toList())
                    .size();
    }

    /**
     * Updates the project name of a task. In case the new name is the same of an existing
     * project, the task will be moved to the new project if this one has not a task with
     * the same title.
     * @throws BusinessModelException with the corresponding error message for the case.
     * @param task object type Task to be updated
     * @param String representing the new project name
     * @return the task updated
     */
    @Override
    public Task updateTaskProjectName(Task task , String newProjectName) {
        if(task != null) {
            Project newProject = new Project(newProjectName);
            Project previousProject = task.getProject();
            // if the project name is the same of a current project
            // the task will be moved to that project
            // (but only if that project does not have a task with that title already)
            if(projects.containsValue(newProject)) {
                Project project = getProject(newProjectName);
                // if the project does not contain the a task with the same title
                // than the requested task to be added the task is moved to the new project
                if(!project.hasTaskTitle(task.getTitle())) {
                    previousProject.removeTask(task);
                    task.setProject(project);
                    project.addTask(task);
                }
                else {
                    throw new BusinessModelException("The Project already exist and " +
                                                     "there is a Task with the same Title in it");
                }
            }
            else {
                // if the project name is not the same of an existing project
                // a new project is created and the task is moved to it
                previousProject.removeTask(task);
                projectId++;
                newProject.setId(projectId);
                newProject.addTask(task);
                projects.put(projectId, newProject);
                task.setProject(newProject);;
            }
            // if the previous project ends up without task in this process
            // then is removed from the App
            if(previousProject.getTasks().isEmpty()) {
                projects.remove(previousProject.getId());
            }
        }
        return task;
    }

    /**
     * Updates the due date of the task.
     * @param task object type Task to be updated
     * @param Date representing the new due date for the task
     * @return the task updated
     */
    @Override
    public Task updateTaskDueDate(Task task, Date dueDate) {
        if(task != null) {
            task.setDueDate(dueDate);
        }
        return task;
    }

    /**
     * Updates the due date of the task.
     * @param task object type Task to be updated
     * @param boolean representing the new status for the task.
     * true = the task is done, false = to do
     * @return the task updated
     */
    @Override
    public Task updateTaskStatus(Task task, boolean status) {
        if(task != null) {
            task.setStatus(status);
        }
        return task;
    }

    /**
     * Updates the title of the task.
     * @param task object type Task to be updated
     * @param String representing the new title for the task
     * @return the task updated
     * @throws BusinessModelException if the project to which this task belongs already
     * has a task with that title.
     */
    @Override
    public Task updateTaskTitle(Task task, String title) {
        if(task != null) {
            if(task.getProject().hasTaskTitle(title)) {
                throw new BusinessModelException("The Project " + task.getProject().getName() +
                                                 " already has a Task with the same Title in it");
            }
            task.setTitle(title);
        }
        return task;
    }
}
