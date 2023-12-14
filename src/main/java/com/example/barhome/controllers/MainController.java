package com.example.barhome.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import com.example.barhome.config.Config;
import com.example.barhome.database.CheckAuth;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController implements Config {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public TextField getLoginField() {
        return loginField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signInButton.setOnAction(actionEvent -> {
            if (new CheckAuth().find_pass_and_user(getLoginField().getText(), getPasswordField().getText())) {
                ListOfDevicesController.login = this.loginField.getText();

                SwitchWindowController.switchWindow(signInButton, homeWindow);
//                signInButton.getScene().getWindow().hide();
//                FXMLLoader loader = new FXMLLoader(Main.class.getResource("homePage-view.fxml"));
//                try {
//                    loader.load();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                Parent root = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));
//                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error: SignIn window");
                alert.setContentText("Invalid login or password");
                alert.setHeaderText("Error 0x1");
                alert.showAndWait();
            }
        });
        signUpButton.setOnAction(actionEvent1 -> {
            SwitchWindowController.switchWindow(signUpButton, signUpWindow);
        });

    }

}
