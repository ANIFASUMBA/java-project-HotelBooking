package com.three.project_java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;

public class loginHelloController implements Initializable {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginmessagelabel;


    @FXML
    private ImageView brandingimageview;

    @FXML
    private ImageView food;

    @FXML
    private ImageView bed;

    @FXML
    private ImageView gm;

    @FXML
    private ImageView lockimageview;

    @FXML
    private TextField usernametextfield;

    @FXML
    private PasswordField enterpasswordfield;

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle) {
        File brandingFile = new File("../../../../../../icon");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingimageview.setImage(brandingImage);

        File foodFile = new File("../../../../../../food.jpeg");
        Image foodImage = new Image(foodFile.toURI().toString());
        food.setImage(foodImage);

        File bedFile = new File("../../../../../../bed.jpeg");
        Image bedImage = new Image(bedFile.toURI().toString());
        bed.setImage(bedImage);

        File lockFile = new File("../../../../../../gm.jpeg");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockimageview.setImage(lockImage);


        File gmFile = new File("../../../../../../zzz.jpeg");
        Image gmImage = new Image(gmFile.toURI().toString());
        gm.setImage(gmImage);

    }


    public void  loginButtonOnAction(ActionEvent event){


        if(usernametextfield.getText().isBlank() == false && enterpasswordfield.getText().isBlank() == false){
            validatelogin();


        }else{

            loginmessagelabel.setText("please enter username and password ");
        }
    }


    @FXML
    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

    public void registersButtonOnAction(ActionEvent event) {
        CreateAccountForms();

    }

    public void validatelogin(){
        database connectionName = new database();
        Connection connection = connectionName.getConnection();

        String verifyLogin = "SELECT count(1) FROM love WHERE username = '" + usernametextfield.getText() +"' AND password = '" + enterpasswordfield.getText() + "'";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){

                if(queryResult.getInt(1) == 1){
                    loginmessagelabel.setText("congratulation");
                    CreateAccountForm();


                }else{
                    loginmessagelabel.setText("invalid login");


                }


            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }



    }


    public void CreateAccountForm(){

        try{
            Parent root = FXMLLoader.load(getClass().getResource("hotel.fxml"));
            Scene scene = new Scene(root, 830, 620);
            Stage registerstage = new Stage();
            registerstage.initStyle(StageStyle.UNDECORATED);
            registerstage.setScene(scene);
            registerstage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }



    }

    public void CreateAccountForms(){

        try{
            Parent root = FXMLLoader.load(getClass().getResource("regester.fxml"));
            Scene scene = new Scene(root, 520, 541);
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