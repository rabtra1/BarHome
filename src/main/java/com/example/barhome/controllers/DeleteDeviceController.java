package com.example.barhome.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.example.barhome.config.Config;
import com.example.barhome.database.Input;
import com.example.barhome.database.OutputInfo;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DeleteDeviceController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text resultOfDelete;

    @FXML
    private Button backButton;

    @FXML
    private VBox vBox;

    @FXML
    void initialize() {
        BackButtonController.back(backButton);

        try {
            HashMap<Integer, String> temp = OutputInfo.listOfDevices(ListOfDevicesController.getLogin());
            ArrayList<Button> buttons = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : temp.entrySet()) {
                Button button1 = new Button();
                button1.setText(entry.getValue());
                button1.setPrefSize(400, 30);
                VBox.setMargin(button1, new Insets(3, 3, 3, 3));
                buttons.add(button1);
            }
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.getChildren().addAll(buttons);

            for (Button button : buttons) {
                button.setOnAction(actionEvent -> {
                    try {
                        Input.deleteDevice(button.getText(), ListOfDevicesController.getLogin());
                        SwitchWindowController.switchWindow(button, deleteDeviceWindow);
                    } catch (ClassNotFoundException e) {
                        resultOfDelete.setText("Ошибка");
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: DeleteDeviceWindow");
            alert.setContentText("Try again");
            alert.setHeaderText("Error 1x4");
            alert.showAndWait();
            throw new RuntimeException(e);
        }

    }

}
