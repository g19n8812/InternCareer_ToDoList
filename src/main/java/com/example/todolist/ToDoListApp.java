package com.example.todolist;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp extends JFrame {

    private JList<String> toDoList;
    private DefaultListModel<String> setToDoListModel;
    private JTextField ToDoListInputField;

    private JButton addTaskButton;
    private JButton markTaskDoneButton;
    private JButton deleteTaskButton;

    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    public JButton getMarkTaskDoneButton() {
        return markTaskDoneButton;
    }

    public JButton getDeleteTaskButton() {
        return deleteTaskButton;
    }

    @Override
    public int getDefaultCloseOperation() {
        return super.getDefaultCloseOperation();
    }

    public JList<String> getToDoList() {
        return toDoList;
    }

    public JTextField getToDoListInputField() {
        return ToDoListInputField;
    }

    public DefaultListModel<String>getSetToDoListModel(){
        return setToDoListModel;
    }



    public ToDoListApp() {

        //set up the display window using swing as a GUI
        setTitle("My TODO List App");
        setSize(600, 600);
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
        toDoList.setCellRenderer(new TaskListLables());

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }

    //number the tasks as the user add/deletes the tasks
    private class TaskListLables extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String task = value.toString();
            if (task.endsWith(" -- Done!")) {
                label.setForeground(Color.GREEN);
            } else {
                label.setForeground(Color.BLACK);
            }
            label.setText((index + 1) + ". " + value.toString());
            return label;
        }
    }

}

