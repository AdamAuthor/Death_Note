package com.example.death_note.controllers;

import com.example.death_note.DBManager;
import com.example.death_note.elements.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerShinigamiAddOwner {

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField leftToLiveField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });

        addButton.setOnAction(actionEvent -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            int leftToLive = Integer.parseInt(leftToLiveField.getText());
            Owner owner = new Owner(login, password, leftToLive);
            DBManager.addOwner(owner);
            loginField.setText("");
            passwordField.setText("");
            leftToLiveField.setText("");
        });
    }

}
