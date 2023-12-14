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

public class ChangeApiTokenController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button changeApiTokenButton;

    @FXML
    private TextField newApiTokenField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        backButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(backButton, personalAccountWindow);
        });

        changeApiTokenButton.setOnAction(actionEvent -> {
            try {
                if (CheckAuth.checkPassword(passwordField.getText())) {
                    Input.changeApiToken(newApiTokenField.getText());
                    SwitchWindowController.switchWindow(backButton, personalAccountWindow);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
