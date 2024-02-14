package com.example.todolist;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToDoList extends Application {

    private ListView<String> listView;
    private TextField textField;

    @Override
    public void start(Stage primaryStage) {
        // Creating UI components
        BorderPane root = new BorderPane();
        listView = new ListView<>();
        textField = new TextField();
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        // Set up layout
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(textField, addButton, deleteButton);
        inputBox.setPadding(new Insets(10));

        root.setCenter(listView);
        root.setBottom(inputBox);

        // Add event handlers
        addButton.setOnAction(event -> addTask());
        deleteButton.setOnAction(event -> deleteTask());

        // Set up the scene
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("ToDo List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addTask() {
        String task = textField.getText().trim();
        if (!task.isEmpty()) {
            listView.getItems().add(task);
            textField.clear();
        }
    }

    private void deleteTask() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            listView.getItems().remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}