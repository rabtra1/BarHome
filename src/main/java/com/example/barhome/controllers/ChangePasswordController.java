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

public class ChangePasswordController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button changePasswordButton;

    @FXML
    private TextField newPasswordField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {

        backButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changePasswordButton, personalAccountWindow);
        });

        changePasswordButton.setOnAction(actionEvent -> {
            try {
                if (CheckAuth.checkPassword(passwordField.getText())) {
                    Input.changePassword(newPasswordField.getText());
                    SwitchWindowController.switchWindow(changePasswordButton, personalAccountWindow);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
