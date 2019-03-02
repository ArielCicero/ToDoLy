package todoly.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Project;
import todoly.model.Task;
import todoly.util.enums.MenuOption;
import todoly.views.ActionView;
import todoly.views.View;

public abstract class Controller {
    protected String errorMessage;
    protected String userInput;
    protected Scanner scanner;
    protected View view;
    protected Map<String,MenuOption> validOptions = new HashMap<>();
        
    protected void validateMenuOption(String input) throws ToDoLyException {
        Set<String> options = validOptions.keySet();
        if(false == options.stream().anyMatch(input::equals)) {
            throw new ToDoLyException("Invalid Input!!! The options are " + options);
        }
    }
    
    public MenuOption getMenuOption() {
        return validOptions.get(userInput);
    }
    
    protected void displayMenu(View view, Scanner scanner) {
        setMenuOption();
        do {
            view.printMenu(errorMessage);
            
            userInput = scanner.nextLine();
            errorMessage = null;
            
            try {
                validateMenuOption(userInput);
            } catch (ToDoLyException e) {
                errorMessage = e.getMessage();
            }
             
        }while(errorMessage != null);
    }
    
    protected List<String> tasksToStringList(List<Task> list) {
        return list.stream().map(x->x.toString()).collect(Collectors.toList());
    }
    
    protected List<String> projectsToStringList(List<Project> list) {
        return list.stream().map(x->x.toString()).collect(Collectors.toList());
    }
    
    protected void setMenuOption() {
        validOptions.put("1", MenuOption.LIST_TASKS_BY_DUE_DATE);
        validOptions.put("2", MenuOption.LIST_TASKS_FILTERED_BY_PROJECT);
        validOptions.put("3", MenuOption.ADD_NEW_TASK);
        validOptions.put("4", MenuOption.UPDATE_TASK_STATUS);
        validOptions.put("5", MenuOption.UPDATE_TASK_TITLE);
        validOptions.put("6", MenuOption.UPDATE_TASK_DUE_DATE);
        validOptions.put("7", MenuOption.UPDATE_TASK_PROJECT);
        validOptions.put("8", MenuOption.REMOVE_TASK);
        validOptions.put("9", MenuOption.SAVE_AND_QUIT);
    }
    
    protected Task getTask(TaskListInterface taskList, ActionView view, Scanner scanner) {
        List<Task> listOfTasks = taskList.getTasks();
        Collections.sort(listOfTasks);
        
        List<String> tasks = tasksToStringList(taskList.getTasks());
        Collections.sort(tasks);
        
        view.printList(errorMessage, tasks);
        
        Task task = null;
        if(tasks != null) {
            do {
                view.askForTaskId(errorMessage, tasks);
                
                userInput = scanner.nextLine();
                errorMessage = null;
                
                task = taskList.getTask(Integer.parseInt(userInput));
                if(task == null) {
                    errorMessage = "The option selected was not correct, try again";
                }
            }while(errorMessage != null);
        }
        
        return task;
    }
    
    protected Project getProject(TaskListInterface taskList, ActionView view, Scanner scanner) {
        List<Project> projectList = taskList.getProjects();
        Collections.sort(projectList);
        
        List<String> projects = projectsToStringList(projectList);
        view.printList(null, projects);
        Project project = null;
        if(projects != null) {
            do {
                view.askForInput(errorMessage, "one of the listed Project ID");
                
                userInput = scanner.nextLine();
                errorMessage = null;
                
                try {
                    project = taskList.getProject(
                                Integer.parseInt(userInput)
                              );
                    if(project == null) {
                        errorMessage = "The option selected was not correct, try again";
                    }
                } catch (NumberFormatException e) {
                    errorMessage = e.getMessage()
                                    .replace("For input string", "Wrong value");
                }
            }while(errorMessage != null);
        }
        
        return project;
    }
}
