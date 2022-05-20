package com.example.death_note.controllers;

import com.example.death_note.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuOwner {

    @FXML
    private Button buyButton;

    @FXML
    private Button killButton;

    @FXML
    private Button resurrectButton;

    @FXML
    private Button readButton;

    @FXML
    private Button exitButton;



    @FXML
    void initialize() {
        resurrectButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("ownerResurrect.fxml"));
            standardScene(fxmlLoader);
        });

        buyButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("ownerBuy.fxml"));
            standardScene(fxmlLoader);
        });

        killButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("ownerKill.fxml"));
            standardScene(fxmlLoader);
        });

        readButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("ownerRead.fxml"));
            standardScene(fxmlLoader);
        });

        exitButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });
    }

    static void standardScene(FXMLLoader fxmlLoader) {
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Death Note");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
