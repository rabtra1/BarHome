package com.example.barhome.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import com.example.barhome.config.Config;
import com.example.barhome.database.Input;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddDeviceController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ScenarioIdOff;

    @FXML
    private Button addDeviceButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameOfDevice;

    @FXML
    private TextField scenarioIdOn;

    private static void add_device(String nameOfDevice, String scenario_id_on, String scenario_id_off, String login) {

        try {
            Input.inputDevice(nameOfDevice, scenario_id_on, scenario_id_off, login);
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: AddDeviceWindow");
            alert.setContentText("Try again");
            alert.setHeaderText("Error 1x3");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }


    @FXML
    void initialize() {
        addDeviceButton.setOnAction(actionEvent -> {
            add_device(nameOfDevice.getText(), scenarioIdOn.getText(), ScenarioIdOff.getText(), ListOfDevicesController.getLogin());
            SwitchWindowController.switchWindow(addDeviceButton, homeWindow);
        });

        BackButtonController.back(backButton);
    }

}
