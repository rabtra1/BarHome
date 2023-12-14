package com.example.barhome.controllers;


import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class HomePageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addSmartDeviceButton;

    @FXML
    private Button deleteDeviceButton;

    @FXML
    private Button personalAccountButton;

    @FXML
    private Button smartDevicesButton;

    @FXML
    private Button turnOffSmartDeviceButton;

    @FXML
    private Button turnOnSmartDeviceButton;

    @FXML
    void initialize() {
        turnOnSmartDeviceButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(turnOnSmartDeviceButton, "turnOn-view.fxml");
        });

        turnOffSmartDeviceButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(turnOffSmartDeviceButton, "turnOff-view.fxml");
        });

        addSmartDeviceButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(addSmartDeviceButton, "addDevice-view.fxml");
        });

        deleteDeviceButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(deleteDeviceButton, "deleteDevice-view.fxml");
        });

        personalAccountButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(personalAccountButton, "personalAccount-view.fxml");
        });

        smartDevicesButton.setOnAction(actionEvent -> {
            SwitchWindowController.switchWindow(smartDevicesButton, "listOfDevices-view.fxml");
        });
    }

}
