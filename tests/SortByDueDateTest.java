package todoly.tests;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.model.TaskList;
import todoly.util.SortByDueDate;

/**
 * Test class for SortByDueDateTest
 * 
 * @author Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
class SortByDueDateTest {

    private static TaskList taskList;
    
    /**
     * Setting up the SortByDueDateTest class creating a task list object and
     * initialising it with tasks and projects.
     */
    @BeforeAll
    public static void setUp() {
        taskList = new TaskList();
        
        taskList.addTask(
                new Project("name of project 1"),
                new Date("2019-5-5"),
                "task title 1"
        );
        
        taskList.addTask(
                new Project("name of project 2"),
                new Date("2020-5-5"),
                "task title 2"
        );
        
        taskList.addTask(
                new Project("name of project 3"),
                new Date("2021-5-5"),
                "task title 3"
        );
        
        taskList.addTask(
                new Project("name of project 1"),
                new Date("2019-6-5"),
                "task title 1"
        );
        
        taskList.addTask(
                new Project("name of project 2"),
                new Date("2020-6-5"),
                "task title 2"
        );
        
        taskList.addTask(
                new Project("name of project 3"),
                new Date("2021-6-5"),
                "task title 3"
        );
        
        taskList.addTask(
                new Project("name of project 1"),
                new Date("2019-6-7"),
                "task title 1"
        );
        
        taskList.addTask(
                new Project("name of project 2"),
                new Date("2020-6-7"),
                "task title 2"
        );
        
        taskList.addTask(
                new Project("name of project 3"),
                new Date("2021-6-7"),
                "task title 3"
        );
    }
    
    /**
     * Assert that compare() method implementation for the SortByDueDate Comparator
     * class orders a list of tasks by its due date. for that purpose uses the
     * compareTo method of LocalDate which returns negative if less, positive if greater.
     * @see LocalDate#compareTo()
     */
    @Test
    void shufflingAndSorting() {
        List<Task> listOfTasks = taskList.getTasks(); 
        
        LocalDate dateOfCurrentTask = null;
        LocalDate dateOfNextTask = null;
        
        int ahuffleAmount = 1000;
        
        for (int i = 0; i < ahuffleAmount; i++) {
            
            Collections.shuffle(listOfTasks);
            
            Collections.sort(listOfTasks, new SortByDueDate());
            
            for (int index = 0; index < listOfTasks.size()-1; index++) {
                dateOfCurrentTask = listOfTasks.get(index).getDueDate().get();
                dateOfNextTask = listOfTasks.get(index+1).getDueDate().get();
                
                assertTrue(dateOfCurrentTask.compareTo(dateOfNextTask) < 0);
            }
        }
    }
}
