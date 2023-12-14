package com.example.barhome.controllers;

import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.example.barhome.database.OutputInfo;
import com.example.barhome.util.TurnOn;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class TurnOnController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    private Boolean status = false;

    @FXML
    private VBox vBox;

    private void onDevice(String nameOfDevice, String login) {
        try {
            String scen =OutputInfo.getScenarioIdOn(nameOfDevice, login);
            String urlOn = String.format("https://api.iot.yandex.net/v1.0/scenarios/%s/actions", scen);
            TurnOn.on(urlOn);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void initialize() {
        try {
            HashMap<Integer, String> temp = OutputInfo.listOfDevices(ListOfDevicesController.getLogin());
            ArrayList<Button> buttons = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : temp.entrySet()) {
                Button button1 = new Button();
                button1.setText(entry.getValue());
//                button1.setStyle("""
//                        -fx-background-color:#FFCC00; -fx-font-size: 15px; -fx-font-weight: bold;
//
//                        """);
                button1.setPrefSize(400, 30);
                VBox.setMargin(button1, new Insets(3, 3, 3, 3));
                buttons.add(button1);
            }
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.getChildren().addAll(buttons);

            for (Button button : buttons) {
                button.setOnAction(actionEvent -> {
                    onDevice(button.getText(), ListOfDevicesController.getLogin());
                    status = !status;
                    if (status){
                        button.setStyle("-fx-background-color: green;");
                    }
                });
            }
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: TurnOnWindow");
            alert.setContentText("Try again");
            alert.setHeaderText("Error 1x1");
            alert.showAndWait();
            throw new RuntimeException(e);
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: TurnOnWindow");
            alert.setContentText("Try to check your internet");
            alert.setHeaderText("Error 1x1");
            alert.showAndWait();
            throw new RuntimeException(ex);
        }

        BackButtonController.back(backButton);

    }

}
