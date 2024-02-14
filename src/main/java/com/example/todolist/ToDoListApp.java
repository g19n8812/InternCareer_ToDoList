package com.example.todolist;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> setToDoListModel;
    private JList<String> todoList;
    private JTextField ToDoListInputField;

    public ToDoListApp() {
        setTitle("My TODO List App");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setToDoListModel = new DefaultListModel<>();
        todoList = new JList<>(setToDoListModel);
        JScrollPane scrollPane = new JScrollPane(todoList);
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
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String task = setToDoListModel.get(selectedIndex);
                    setToDoListModel.set(selectedIndex, task + " -- Done!");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(ToDoListInputField);
        inputPanel.add(addTaskButton);
        inputPanel.add(markTaskDoneButton);

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


