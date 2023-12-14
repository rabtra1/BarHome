package com.example.barhome.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PersonalAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Text loginText;

    @FXML
    private Button backButton;

    @FXML
    private Button changeApiTokenButton;

    @FXML
    private Button changeClientIdButton;

    @FXML
    private Button changeLoginButton;

    @FXML
    private Button changePasswordButton;

    @FXML
    void initialize() {

        BackButtonController.back(backButton);

        loginText.setText(ListOfDevicesController.getLogin());

        changeLoginButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changeLoginButton, "changeLogin-view.fxml");
        });

        changeClientIdButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changeClientIdButton, "changeClientId-view.fxml");
        });

        changePasswordButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changePasswordButton, "changePassword-view.fxml");
        });

        changeApiTokenButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(changeApiTokenButton, "changeApiToken-view.fxml");
        });
    }

}
