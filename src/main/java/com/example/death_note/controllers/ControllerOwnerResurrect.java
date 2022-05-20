package com.example.death_note.controllers;

import com.example.death_note.DBManager;
import com.example.death_note.elements.Killed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerOwnerResurrect {

    @FXML
    private Button backButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button resurrectButton;


    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        ArrayList<Killed> killeds = DBManager.read();
        String str = "";
        for (Killed killed : killeds) {
            str += killed + "\n";
        }
        textArea.setText(str);

        resurrectButton.setOnAction(actionEvent -> {
            String st = loginField.getText();
            DBManager.resurrect(Long.parseLong(st));
            ArrayList<Killed> killeds2 = DBManager.read();
            String str2 = "";
            for (Killed killed : killeds2) {
                str2 += killed + "\n";
            }
            textArea.setText(str2);
            loginField.setText("");
        });
        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });
    }
}
