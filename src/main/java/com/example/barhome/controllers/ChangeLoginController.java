package com.example.barhome.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.barhome.config.Config;
import com.example.barhome.database.CheckAuth;
import com.example.barhome.database.Input;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ChangeLoginController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button changeLoginButton;

    @FXML
    private TextField newLoginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changeLoginButton, personalAccountWindow);
        });

        changeLoginButton.setOnAction(actionEvent -> {
            String login = newLoginField.getText();
            String password = passwordField.getText();
            try {
                if (CheckAuth.checkPassword(password)) {
                    Input.changeLogin(login);
                    ListOfDevicesController.setLogin(login);
                    SwitchWindowController.switchWindow(changeLoginButton, personalAccountWindow);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
