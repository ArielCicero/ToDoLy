package todoly.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;

public class TaskList implements TaskListInterface{
    private Map<Integer,Task> tasks = new HashMap<>();
    private Map<Integer,Project> projects = new HashMap<>();
    private Integer projectId = 0;
    private Integer taskId = 0;

    @Override
    public List<Task> getTasks() {
        return  new ArrayList<Task>(tasks.values());
    }

    @Override
    public List<Project> getProjects() {
        return new ArrayList<Project>(projects.values());
    }
    
    @Override
    public List<Task> getTasksFilteredByProject(Integer projectId) {
        List<Task> returnList = new ArrayList<Task>();
        returnList.addAll(projects.get(projectId).getTasks());
        return returnList;
    }

    @Override
    public void addTask(Task newTask) {
        Integer id = ++taskId;
        // a new task can not have an id already
        if(newTask.getId() == null) {
            Integer projectIdOfNewTask = newTask.getProject().getId();
            
            if(projectIdOfNewTask == null) {
                Project newProject = newTask.getProject();
                // if the project is new as well
                if(!projects.containsValue(newProject)) {
                    newTask.setId(id);
                    tasks.put(id, newTask);
                    
                    id = ++projectId;
                    newProject.setId(id);
                    newProject.addTask(newTask);
                    projects.put(id, newProject);
                }
                // the user put the name of an already existing and listed project
                else {
                    for (Project project : projects.values()) {
                        if(project.equals(newProject)) {
                            // if the project does not contain the the task requested to be added
                            if(!project.getTasks().contains(newTask)) {
                                newTask.setId(id);
                                tasks.put(id, newTask);
                                newTask.setProject(project);
                                project.addTask(newTask);
                                break;
                            }
                            else {
                                throw new ToDoLyException("The Task already exist");
                            }
                        }
                    }
                }
            }
            //else if project does not contains a task with this name
            else if(!projects.get(projectIdOfNewTask).getTasks().contains(newTask)){
                newTask.setId(id);
                tasks.put(id, newTask);
                projects.get(projectIdOfNewTask).addTask(newTask);
            }
            else {
                throw new ToDoLyException("The Task already exist");
            }
        }
        else {
            throw new ToDoLyException("The Task already exist");
        }
        
    }

    @Override
    public void removeTask(Integer taskId) {
        Task removedTask = tasks.remove(taskId);
        Project projectOfRemovedTask = removedTask.getProject();
        projectOfRemovedTask.getTasks().remove(removedTask);
        if(projectOfRemovedTask.getTasks().isEmpty()) {
            projects.remove(projectOfRemovedTask.getId());
        }
    }

    @Override
    public int getTasksAmount() {
        return tasks.values().size();
    }

    @Override
    public int getTasksDoneAmount() {
        return tasks.values()
                    .stream()
                    .filter(x->x.isDone())
                    .collect(Collectors.toList())
                    .size();
    }

    @Override
    public Task getTask(Integer taskId) {
        return tasks.get(taskId);
    }

    @Override
    public Project getProject(Integer userInput) {
        return projects.get(userInput);
    }

    // in case the new name is the same os an existing project,
    // the task will be moved to the new project
    @Override
    public void updateTaskProjectName(String projectName, Task task) {
        Project auxProject = new Project(projectName);
        if(projects.containsValue(auxProject)) {
            for (Project project : projects.values()) {
                if(project.equals(auxProject)) {
                    // if the project does not contain the the task requested to be added
                    // the task is moved to the new project
                    if(!project.getTasks().contains(task)) {
                        Project previousProject = task.getProject();
                        previousProject.removeTask(task);
                        task.setProject(project);
                        project.addTask(task);
                        // if the previous project ends up without task in this process
                        // then is removed from the task list
                        if(previousProject.getTasks().isEmpty()) {
                            projects.remove(previousProject.getId());
                        }
                        break;
                    }
                    else {
                        throw new ToDoLyException("The Project already exist and "
                                                + "there is a similar Task in it");
                    }
                }
            }
        }
        else {
            task.getProject().setName(projectName);
        }
        
    }
    
}
