package com.example.todolist;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> setToDoListModel;
    private JList<String> toDoList;
    private JTextField ToDoListInputField;

    public ToDoListApp() {
        //set up GUI
        setTitle("My TODO List App");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setToDoListModel = new DefaultListModel<>();
        toDoList = new JList<>(setToDoListModel);
        JScrollPane scrollPane = new JScrollPane(toDoList);
        ToDoListInputField = new JTextField(20);


        //allow user to add a task
        JButton addTaskButton = new JButton("Add");
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toAddItem = ToDoListInputField.getText();
                if (!toAddItem.isEmpty()) {
                    setToDoListModel.addElement(toAddItem);
                    ToDoListInputField.setText("");
                }
            }
        });


        //allow user to select and mark a task as Done
        JButton markTaskDoneButton = new JButton("Mark as Done");
        markTaskDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String task = setToDoListModel.get(selectedIndex);
                    setToDoListModel.set(selectedIndex, task + " -- Done!");
                }
            }
        });


        //allow user to select and delete a task from the list
        JButton deleteTaskButton = new JButton("Delete");
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    setToDoListModel.remove(selectedIndex);
                }
            }
        });


        JPanel inputPanel = new JPanel();
        inputPanel.add(ToDoListInputField);
        inputPanel.add(addTaskButton);
        inputPanel.add(markTaskDoneButton);
        inputPanel.add(deleteTaskButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }
}


