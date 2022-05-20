package com.example.death_note.controllers;

import com.example.death_note.DBManager;
import com.example.death_note.elements.Killed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerOwnerRead {

    @FXML
    private Button backButton;

    @FXML
    private Button showButton;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });

        showButton.setOnAction(actionEvent -> {
            ArrayList<Killed> killeds = DBManager.read();
            String str = "";
            for (Killed killed : killeds) {
                str += killed + "\n";
            }
            textArea.setText(str);
        });
    }
}
