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
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toAddItem = ToDoListInputField.getText();
                if (!toAddItem.isEmpty()) {
                    setToDoListModel.addElement(toAddItem);
                    ToDoListInputField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(ToDoListInputField);
        inputPanel.add(addButton);


    }

    public static void main(String[] args) {

    }

}