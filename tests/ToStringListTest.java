package todoly.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import todoly.model.Date;
import todoly.model.Project;
import todoly.model.Task;
import todoly.model.TaskList;
import todoly.util.ToStringList;

/**
 * Test class for ToStringListTest
 * 
 * @author Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
class ToStringListTest {
    
    private static TaskList taskList;
    
    /**
     * Setting up the ToStringListTest class creating a task list object and
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
                new Date("2019-5-5"),
                "task title 2"
        );
        
        taskList.addTask(
                new Project("name of project 3"),
                new Date("2019-5-5"),
                "task title 3"
        );
    }

    /**
     * Assert that ToStringList.convert() converts all the Objects elements
     * of a ArrayList in Strings
     */
    @Test
    void convertingArrayListOfObjects() {
        List<Object> listOfObjects = new ArrayList<>();
        listOfObjects.add(new Object());
        listOfObjects.add(new Object());
        listOfObjects.add(new Object());
        
        
        for (Object object : listOfObjects) {
            assertNotEquals(String.class, object.getClass());
        }

        for (Object object : ToStringList.convert(listOfObjects)) {
            assertEquals(String.class, object.getClass());
        }
    }
    
    /**
     * Assert that ToStringList.convert() converts all the Objects elements
     * of a LinkedList in Strings
     */
    @Test
    void convertingLinkedListOfObjects() {
        List<Object> listOfObjects = new LinkedList<>();
        listOfObjects.add(new Object());
        listOfObjects.add(new Object());
        listOfObjects.add(new Object());
        
        
        for (Object object : listOfObjects) {
            assertNotEquals(String.class, object.getClass());
        }

        for (Object object : ToStringList.convert(listOfObjects)) {
            assertEquals(String.class, object.getClass());
        }
    }
    
    /**
     * Assert that ToStringList.convert() returns a list with the same
     * amount of elements than the list sent as a parameter
     */
    @Test
    void sizeIsTheSameOfListSentAsParameter() {
        List<Task> listOfTasks = taskList.getTasks();
        
        List<String> listConverted = ToStringList.convert(listOfTasks);
        
        assertEquals(listOfTasks.size(), listConverted.size());
    }
    
    /**
     * Assert that ToStringList.convert() converts a list of tasks in
     * a list of strings representing each each task converted to string
     * using the toString() method
     */
    @Test
    void taskListToStringList() {
        List<Task> listOfTasks = taskList.getTasks();
        
        List<String> listConverted = ToStringList.convert(listOfTasks);
        
        for (int index = 0; index < listConverted.size(); index++) {
            Task task = listOfTasks.get(index);
            String taskToString = listConverted.get(index);
            assertTrue(task.toString().equals(taskToString));
        }
    }
    
    /**
     * Assert that ToStringList.convert() converts a list of projects in
     * a list of strings representing each each project converted to string
     * using the toString() method
     */
    @Test
    void projectListToStringList() {
        List<Project> listOfOProjects = taskList.getProjects();
        
        List<String> listConverted = ToStringList.convert(listOfOProjects);
        
        for (int index = 0; index < listConverted.size(); index++) {
            Project project = listOfOProjects.get(index);
            String projectToString = listConverted.get(index);
            assertTrue(project.toString().equals(projectToString));
        }
    }
    
    /**
     * Assert that ToStringList.convert() returns null
     * when the parameter is null.
     */
    @Test
    void checkReturnNullWhenParameterIsNull() {
        // Act, Assert
        assertEquals(null, ToStringList.convert(null));
    }
}
