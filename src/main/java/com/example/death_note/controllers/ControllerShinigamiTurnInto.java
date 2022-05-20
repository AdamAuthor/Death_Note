package com.example.death_note.controllers;

import com.example.death_note.DBManager;
import com.example.death_note.elements.Owner;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerShinigamiTurnInto {

    @FXML
    private Button backButton;

    @FXML
    private TextField loginField;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextArea textArea;

    @FXML
    private Button turnButton;

    @FXML
    void initialize() {
        ArrayList<Owner> owners = DBManager.killOwner();
        String str = "";
        for (Owner owner : owners) {
            str += owner + "\n";
        }
        textArea.setText(str);

        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });
    }
}
