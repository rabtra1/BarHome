package com.example.barhome.controllers;


import java.net.URL;
import java.util.ResourceBundle;

import com.example.barhome.config.Config;
import com.example.barhome.database.CheckAuth;
import com.example.barhome.database.Input;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class SignUpController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TextField apiTokenField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField clientIdField;

    @FXML
    private Button signUpButton;

    private static void register(String login, String password, String api_token, String client_id) {
        try {
            Input.input(login, password, api_token, client_id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() {
        signUpButton.setOnAction(actionEvent -> {
            if (CheckAuth.find_user(loginField.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText("INFO: This user is already exists");
                alert.setHeaderText("Error 0x2");
                alert.showAndWait();
            } else {
                register(loginField.getText(), passwordField.getText(), apiTokenField.getText(), clientIdField.getText());
                SwitchWindowController.switchWindow(signUpButton, mainWindow);
            }
        });

        backButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(backButton, mainWindow);
        });
    }


}
