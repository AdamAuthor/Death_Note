package com.example.death_note.controllers;

import com.example.death_note.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuShinigami {

    @FXML
    private Button addOwnerButton;

    @FXML
    private Button killOwnerButton;

    @FXML
    private Button giftButton;

    @FXML
    private Button turnIntoButton;

    @FXML
    private Button exitShinigamiButton;

    @FXML
    void initialize() {
        addOwnerButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("shinigamiAddOwner.fxml"));
            standardScene(fxmlLoader);
        });

        exitShinigamiButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) exitShinigamiButton.getScene().getWindow();
            stage.close();
        });

        killOwnerButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("shinigamiKillOwner.fxml"));
            standardScene(fxmlLoader);
        });

        turnIntoButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("shinigamiTurnInto.fxml"));
            standardScene(fxmlLoader);
        });

        giftButton.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("shinigamiGiftEraser.fxml"));
            standardScene(fxmlLoader);
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
