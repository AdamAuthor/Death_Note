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

public class ControllerShinigamiGiftEraser {

    @FXML
    private Button backButton;

    @FXML
    private Button giftButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        ArrayList<Owner> owners = DBManager.killOwner();
        String str = "";
        for (Owner owner : owners) {
            str += owner + "\n";
        }
        textArea.setText(str);

        giftButton.setOnAction(actionEvent -> {
            loginField.setText("");
        });

        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });
    }

}
