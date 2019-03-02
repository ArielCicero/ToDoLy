package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.exceptions.ToDoLyException;
import todoly.interfaces.TaskListInterface;
import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.views.ActionView;

public class AddNewTaskController extends Controller {

    public AddNewTaskController(TaskListInterface taskList, Scanner scanner) {
        
        ActionView view = new ActionView(
                                Integer.toString(taskList.getTasksAmount()),
                                Integer.toString(taskList.getTasksDoneAmount())
                            );
        
        List<Project> projectList = taskList.getProjects();
        Collections.sort(projectList);
        
        List<String> projects = projectsToStringList(projectList);
        view.printList(null, projects);
        
        Task task = new Task();
        
        do {
            Project project = null;
            Integer projectId = null;
            
            if(projects != null) {
                view.askForInput(errorMessage, "one of the listed Project ID or"
                                             + ", otherwise, write a New Project Name");
            }
            else {
                view.askForInput(errorMessage, "the Project Name (\"ön\" and \"<3\" are valid names)");
            }
            userInput = scanner.nextLine();
            errorMessage = null;
            
            try {
                projectId = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                try {
                    project = new Project(userInput);
                } catch (ToDoLyException e2) {
                    errorMessage = e2.getMessage();
                }
            }
            
            if(project == null) {
                project = taskList.getProject(projectId);
                
                if(project == null) {
                    errorMessage = "There is no Project with id number " + userInput;
                }
            }
            
            task.setProject(project);
            
        }while(errorMessage != null);
        
        
        do {
            view.askForInput(errorMessage, "Due Date (date format YYYY-MM-DD = \"2012-7-1\")");
            userInput = scanner.nextLine();
            errorMessage = null;
            try {
                // date format YYYY-MM-DD = "2012-7-1"
                task.setDueDate(new Date(userInput));
                errorMessage = null;
            } catch (ToDoLyException e) {
                errorMessage = e.getMessage();
            }
        }while(errorMessage != null);
        
        do {
            view.askForInput(errorMessage, "New Task Title");
            userInput = scanner.nextLine();
            errorMessage = null;
            try {
                task.setTitle(userInput);
                taskList.addTask(task);
            } catch (ToDoLyException e) {
                errorMessage = e.getMessage();
            }
        }while(errorMessage != null);
        
        view.printConfirmation("The Task Has Been Added Successfully", task.toString());
        
        view.tasksAmount = (Integer.parseInt(view.tasksAmount) + 1) + "";

        displayMenu(view, scanner);
    }
}
