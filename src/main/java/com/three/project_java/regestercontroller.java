package com.three.project_java;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.sql.Connection;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class regestercontroller implements Initializable {

    @FXML
    private ImageView shieldimageview;

    @FXML
    private Button closebutton;

    @FXML
    private Label regestrationusermessage;

    @FXML
    private PasswordField setpasswordfield;

    @FXML
    private PasswordField ConfirmPasswordField;

    @FXML
    private Label confirmpasswordlabel;

    @FXML
    private TextField firstnametextfield;

    @FXML
    private TextField lastnametextfield;

    @FXML
    private TextField usernametextfield;


    public void initialize(URL url , ResourceBundle resourceBundle) {
        File shieldFile = new File("../../../../../../walk.jpeg");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldimageview.setImage(shieldImage);

    }


    public void  registerButtonOnAction(ActionEvent event){
        if(setpasswordfield.getText().equals(ConfirmPasswordField.getText())){
            registerUser();
            confirmpasswordlabel.setText("");
            regestrationusermessage.setText("regestered succecssful");



        }else{
            confirmpasswordlabel.setText("password do not match");
        }

    }


    public void  closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        Platform.exit();


    }

    public void registerUser() {
        database connectionName = new database();
        Connection connection = connectionName.getConnection();

        String firstname = firstnametextfield.getText();
        String lastname = lastnametextfield.getText();
        String username = usernametextfield.getText();
        String password = setpasswordfield.getText();

        String insertToRegister = "INSERT INTO love (firstname, lastname, username, password) VALUES ('"
                 + firstname + "', '" + lastname + "', '" + username + "', '" + password + "')";

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(insertToRegister);

            if (result > 0) {
                regestrationusermessage.setText("User registered successfully!");

            } else {
                regestrationusermessage.setText("User registration failed.");
            }

        } catch ( Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void  hotelButtonOnAction(ActionEvent event){
        if(setpasswordfield.getText().equals(ConfirmPasswordField.getText())){
            CreateAccountForm();
        }
    }

    public void CreateAccountForm(){



        try{
            Parent root = FXMLLoader.load(getClass().getResource("hotel.fxml"));
            Scene scene = new Scene(root, 900, 700);
            Stage registerstage = new Stage();
            registerstage.initStyle(StageStyle.UNDECORATED);
            registerstage.setScene(scene);
            registerstage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }



    }


}
