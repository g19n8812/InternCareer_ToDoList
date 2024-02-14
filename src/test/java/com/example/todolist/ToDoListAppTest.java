package com.example.todolist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ToDoListAppTest {

    private ToDoListApp toDoListApp;

    @Before
    public void setUp() {
        toDoListApp = new ToDoListApp();
    }

    @Test
    public void testAddTask() {

        toDoListApp.getToDoListInputField().setText("Test Task");
        toDoListApp.getAddTaskButton().doClick();
        assertEquals(1, toDoListApp.getSetToDoListModel().getSize());
        assertEquals("Test Task", toDoListApp.getSetToDoListModel().get(0));
    }

    @Test
    public void testMarkTaskAsDone() {
        toDoListApp.getSetToDoListModel().addElement("Test Task");
        toDoListApp.getToDoList().setSelectedIndex(0);
        toDoListApp.getMarkTaskDoneButton().doClick();
        assertEquals(1, toDoListApp.getSetToDoListModel().getSize());
        assertEquals("Test Task -- Done!", toDoListApp.getSetToDoListModel().get(0));
    }

    @Test
    public void testDeleteTask() {
        toDoListApp.getSetToDoListModel().addElement("Test Task");
        toDoListApp.getToDoList().setSelectedIndex(0);
        toDoListApp.getDeleteTaskButton().doClick();
        assertEquals(0, toDoListApp.getSetToDoListModel().getSize());
    }
}