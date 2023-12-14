package com.example.barhome.controllers;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.example.barhome.database.OutputInfo;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ListOfDevicesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    String result = "";

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        ListOfDevicesController.login = login;
    }

    public static String login = "";

    @FXML
    private Button backButton;

    @FXML
    private Label devicesLabel;

    @FXML
    void initialize() {
        try {
            HashMap<Integer, String> temp = OutputInfo.listOfDevices(getLogin());
            for (Map.Entry<Integer, String> entry : temp.entrySet()) {
                result += entry.getValue() + "\n";
            }
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: AddDeviceWindow");
            alert.setContentText("Try again");
            alert.setHeaderText("Error 1x5");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
        devicesLabel.setText(result);

        BackButtonController.back(backButton);


    }

}
