package com.three.project_java;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class hotelregester  implements Initializable {

    @FXML
    private TextField bookusername;


    @FXML
    private PasswordField bookpassword;

    @FXML
    private DatePicker datepicker;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private ChoiceBox<String> mychoicebox;

    @FXML
    private RadioButton rbutton1 ,rbutton2,rbutton3;

    @FXML
    private Label displaybook;

    @FXML
    private Label displaybook1;

    @FXML
    private Label displaybook11;

    @FXML
    private Label displaybook111;

    @FXML
    private ImageView food1;

    @FXML
    private ImageView love1;

    @FXML
    private ImageView food2;

    @FXML
    private ImageView love2;

    @FXML
    private ImageView food3;

    @FXML
    private ImageView gym;

    @FXML
    private ImageView wifi;

    @FXML
    private ImageView theatre;

    @FXML
    private ImageView swim;

    @FXML
    private ImageView love3;


    private String [] rooms = {"one room","two rooms","three rooms","four rooms","five rooms"};

    public void numberofrooms(ActionEvent event){

        String room = mychoicebox.getValue();
        displaybook111.setText(room);
    }

    @Override
    public void initialize(URL url , ResourceBundle resourceBundle ) {

        mychoicebox.getItems().addAll(rooms);
        mychoicebox.setOnAction(this::numberofrooms);

        File brandingFile = new File("../../../../../../food.jpeg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        food1.setImage(brandingImage);

        File foodFile = new File("../../../../../../love.jpeg");
        Image foodImage = new Image(foodFile.toURI().toString());
        love1.setImage(foodImage);

        File bedFile = new File("../../../../../../food.jpeg");
        Image bedImage = new Image(bedFile.toURI().toString());
        food2.setImage(bedImage);

        File lockFile = new File("../../../../../../love.jpeg");
        Image lockImage = new Image(lockFile.toURI().toString());
        love2.setImage(lockImage);


        File gmFile = new File("../../../../../../food.jpeg");
        Image gmImage = new Image(gmFile.toURI().toString());
        food3.setImage(gmImage);


        File love3File = new File("../../../../../../love.jpeg");
        Image love3Image = new Image(love3File.toURI().toString());
        love3.setImage(love3Image);


        File gymFile = new File("../../../../../../gym.jpeg");
        Image gymImage = new Image(gymFile.toURI().toString());
        gym.setImage(gymImage);


        File wifiFile = new File("../../../../../../wifi.jpeg");
        Image wifiImage = new Image(wifiFile.toURI().toString());
        wifi.setImage(wifiImage);

        File theatreFile = new File("../../../../../../theatre.jpeg");
        Image theatreImage = new Image(theatreFile.toURI().toString());
        theatre.setImage(theatreImage);


        File swimFile = new File("../../../../../../swim.jpeg");
        Image swimImage = new Image(swimFile.toURI().toString());
        swim.setImage(swimImage);

    }

    public void  bookButtonOnAction(ActionEvent event){
        bookroom();
    }

    public void bookroom() {
        database connectionName = new database();
        Connection connection = connectionName.getConnection();

        String firstname = bookpassword.getText();
        String lastname = bookusername.getText();
        LocalDate date1 = datepicker.getValue();
        LocalDate date2 = datepicker1.getValue();
        String room = mychoicebox.getValue();
        String stand = rbutton1.getText();
        String deluxe = rbutton1.getText();
        String suite = rbutton1.getText();




        String insertToRegister = "INSERT INTO hotel (firstname, lastname, date1, date2,room,stand,deluxe,suite) VALUES ('"
                + firstname + "', '" + lastname + "', '" + date2 + "', '" + date1 + "', '" + room + "', '" + stand + "', '" + deluxe + "', '" + suite + "')";

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(insertToRegister);

            if (result > 0) {
                displaybook.setText("booked successfully!");

            } else {
                displaybook.setText("booked failed.");
            }

        } catch ( Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void setdate(ActionEvent event){
        LocalDate myDate = datepicker.getValue();
        displaybook.setText(myDate.toString());

    }

    public void setdate1(ActionEvent event){
        LocalDate myDate = datepicker1.getValue();
        displaybook1.setText(myDate.toString());

    }

    public void getroom(ActionEvent event){
        if(rbutton1.isSelected()){
            displaybook11.setText(rbutton1.getText());
        }
        else if (rbutton2.isSelected()){
            displaybook11.setText(rbutton2.getText());
        }
        else if (rbutton3.isSelected()){
            displaybook11.setText(rbutton3.getText());
        }

    }


}
