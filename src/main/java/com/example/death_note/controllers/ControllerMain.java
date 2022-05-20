package com.example.death_note.controllers;

import com.example.death_note.Client;
import com.example.death_note.DBManager;
import com.example.death_note.elements.Owner;
import com.example.death_note.elements.Shinigami;
import com.example.death_note.elements.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerMain {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signButton;

    @FXML
    void initialize() {
        signButton.setOnAction(actionEvent -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            ArrayList<User> users = DBManager.signIn();
            for (User user : users) {
                if(user instanceof Shinigami && user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    signButton.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("menuShinigami.fxml"));
                    stand(fxmlLoader);
                    break;

                } else if (user instanceof Owner && user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    signButton.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader(Client.class.getResource("menuOwner.fxml"));
                    stand(fxmlLoader);

                }
            }
            
            loginField.setText("");
            passwordField.setText("");
        });
    }

    private void stand(FXMLLoader fxmlLoader) {
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Death Note");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        return;
    }


}
