package com.example.death_note.controllers;

import com.example.death_note.DBManager;
import com.example.death_note.elements.Killed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerOwnerKill {

    @FXML
    private TextField ageField;

    @FXML
    private Button backButton;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private Button killButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField nationalityField;

    @FXML
    private TextField surnameField;

    @FXML
    void initialize() {
        genderComboBox.getItems().addAll("male", "female", "other");
        genderComboBox.setStyle("-fx-background-color: 'white'; -fx-border-color: '#e0001a';-fx-font-family: 'DEATHNOTE Font'; -fx-font-size: 37");

        backButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });

        killButton.setOnAction(actionEvent -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String gender = genderComboBox.getValue();
            String nationality = nationalityField.getText();
            int age = Integer.parseInt(ageField.getText());
            Killed killed = new Killed(name, surname, gender, nationality, age);
            DBManager.kill(killed);
            nameField.setText("");
            surnameField.setText("");
            genderComboBox.setValue("");
            nationalityField.setText("");
            ageField.setText("");
        });
    }
}
