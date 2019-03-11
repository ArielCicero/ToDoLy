package todoly.controllers.actions;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.model.Project;
import todoly.model.Task;
import todoly.model.TaskListInterface;
import todoly.util.ToStringList;
import todoly.views.View;

public class ListTasksFilteredByProjectController extends Controller {

    public ListTasksFilteredByProjectController(TaskListInterface taskList, Scanner scanner) {
        // controller initialisation
        super(new View(), scanner);
        
        // getting and sorting the projects that will be displayed to the user
        List<Project> projectList = taskList.getProjects();
        Collections.sort(projectList);
        
        // parsing the list of projects to a string list so they can be displayed
        // in a text base App
        List<String> projects = ToStringList.convert(projectList);
        
        // displaying the list of projects
        view.printList(projects);
        
        Project project = null;
        // checking that there were projects before to ask to the user for a project ID
        if(projects != null && !projects.isEmpty()) {
            // looping until the user inserts a valid project id
            do {
                // asking for one of the listed project IDs
                view.askForProjectId(errorMessage);
                
                // getting the user input, saving it in a class field
                // and initialising errorMessage to null again
                scanUserInput();
                
                try {
                    // getting the project to filter for
                    // NumberFormatException if userInput is not an integer number
                    project = taskList.getProject(Integer.parseInt(userInput));
                    if(project == null) {
                        errorMessage = "There are no projects with this id: " + userInput;
                    }
                } catch (NumberFormatException e) {
                    errorMessage = e.getMessage().replace("For input string", "Wrong value");
                }
            }while(errorMessage != null);
            
            // getting the tasks belonging to this project
            List<Task> listOfTasks = project.getTasks();
            
            // if a project exists means there is at least one task inside it
            if(listOfTasks != null) {
                Collections.sort(listOfTasks);
                
                // converting the list of projects to a string list
                // so they can be displayed in a text base App
                List<String> tasks = ToStringList.convert(listOfTasks);
                
                view.printList(tasks);
            }
        }
        
        // displaying the menu and getting the menu option chosen by the user
        displayMenu(taskList);
    }
}
