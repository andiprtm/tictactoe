package com.example.tictactoee;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloController {
    public Label label_header;
    public Button btn_manusia;
    public Button btn_cmputer;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToManusia(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manusia.fxml")));
        stage = (Stage) btn_manusia.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIC TAC TOE V1.0");
        stage.show();
    }

    public void switchToComputer(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("computer.fxml")));
        stage = (Stage) btn_cmputer.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIC TAC TOE V1.0");
        stage.show();
    }



}