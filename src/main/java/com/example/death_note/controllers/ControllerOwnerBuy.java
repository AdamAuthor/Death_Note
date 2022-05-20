package com.example.death_note.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerOwnerBuy {

    @FXML
    private Button backButton;

    @FXML
    private Button buyEraser;

    @FXML
    private Button buyEye;

    @FXML
    private Button buyPen;

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });
    }
}