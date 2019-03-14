package todoly.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.model.BusinessModelException;
import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.util.ToStringList;
import todoly.views.View;

/**
 * The <code>AddNewTaskController</code> class extends <code>Controller</code>
 * abstract class and implements the functionality to process the addition
 * of a new task in the <code>ToDoLy</code> text based App.
 * @see Controller
 * @author  Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
public class AddNewTaskController extends Controller {

    /**
     * Since this class has the specific purpose of adding a new task in the application,
     * the constructor initialise the parameters needed for that purpose and works as a
     * template that perform the process intended.
     * @param taskList
     * @param scanner
     * @see TaskListInterface
     * @see Scanner
     */
    public AddNewTaskController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // getting and sorting the projects that will be displayed to the user
        List<Project> projectList = taskList.getProjects();
        Collections.sort(projectList);
        
        Project project = null;
        Integer projectId = null;
        
        // if there are elements in in the list to be displayed
        if(projectList != null && !projectList.isEmpty()) {
            // converting the list of projects to a string list
            // so they can be displayed in a text base App
            List<String> projects = ToStringList.convert(projectList);
            
            // displaying the project list
            view.printList(projects);
            
            // looping until the user inserts a valid option
            do {
                // ask for project id or zero (0) to write new project name
                view.askForProjectIdOrZero(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // validating Integer insertion by the user
                    // NumberFormatException if userInput is not an integer number
                    projectId = Integer.parseInt(userInput);
                    
                    // checking if the user wants to write a name instead of picking 
                    // an existing project id
                    if(projectId == 0) {
                        break;
                    }
                    // getting the project for the new task
                    project = taskList.getProject(projectId);
                    if(project == null) {
                        errorMessage = "There are no projects with this id: " + projectId;
                    }
                } catch (NumberFormatException e) {
                    errorMessage = e.getMessage().replace("For input string", "Wrong value");
                }
            }while(errorMessage != null);
        }
        
        String projectName = null;
        // if there are no elements in the project list
        // or the user inserted 0  to be able to write the project name
        if(projectId == null || projectId == 0 || projectList.isEmpty()) {
            // looping until the user inserts a valid project name
            do {
                // asking for project name
                view.askForProjectName(errorMessage);
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // BusinessModelException if the user wrote a non valid project name
                    projectName = Project.validateName(userInput);
                    // getting the project for the new task
                    project = taskList.getProject(projectName);
                    // if there was no project with that name project = null
                    if(project == null) {
                        project = new Project(projectName);
                    }
                } catch (BusinessModelException e) {
                    errorMessage = e.getMessage();
                }
            }while(errorMessage != null);
        }
        
        Date date = null;
        // looping until the user inserts a valid date
        do {
            // asking for the date
            view.askForDueDate(errorMessage);
            // getting the user input, saving it in a class field
            // and initialising errorMessage to null again
            scanUserInput();
            try {
                // right date format YYYY-MM-DD = "2012-7-1"
                // BusinessModelException if user write a non valid date (bad format)
                // BusinessModelException if user write past date
                date = new Date(userInput);
            } catch (BusinessModelException e) {
                errorMessage = e.getMessage();
            }
        }while(errorMessage != null);
        
        Task task = null;
        String taskTitle = null;
        // looping until the user inserts a valid task title
        do {
            // asking for the task title
            view.askForTaskTitle(errorMessage);
            // getting the user input, saving it in a class field
            // and initialising errorMessage to null again
            scanUserInput();

            try {
                // BusinessModelException if the user wrote a non valid task title
                taskTitle = Task.validateTitle(userInput);
                
                // adding the new task
                // BusinessModelException if the user is trying to add a task with a title
                // that already exist in the chosen project
                task = taskList.addTask(project, date, taskTitle);
            } catch (BusinessModelException e) {
                errorMessage = e.getMessage();
            }
        }while(errorMessage != null);
        
        // confirming operation result
        diplayConfirmation(task);
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
