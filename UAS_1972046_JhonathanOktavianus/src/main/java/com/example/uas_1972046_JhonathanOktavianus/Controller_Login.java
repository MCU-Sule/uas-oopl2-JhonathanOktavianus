package com.example.uas_1972046_JhonathanOktavianus;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 1972046 - Jhonathan Oktavianus
 */
public class Controller_Login {
    public TextField txtId;
    public PasswordField txtPass;
    public GridPane baseLayout;
    private Stage stage;

    public void loginAction(ActionEvent event) throws IOException {
        if (txtId.getText().equals("1972046") && txtPass.getText().equals("123qwe") ){
            Stage new_stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root = loader.load();
            com.example.uas_1972046_JhonathanOktavianus.Controller_Main ctrl2 = loader.getController();
            ctrl2.setController(this);

            Scene new_scene = new Scene(root);
            new_stage.setScene(new_scene);
            new_stage.initModality(Modality.WINDOW_MODAL);
            new_stage.setTitle("Main Form 1972046 Jhonathan Oktavianus");
            stage = (Stage) baseLayout.getScene().getWindow();
            stage.close();
            new_stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wrong ID or Password!");
            alert.showAndWait();
        }
    }
}
