package com.three.project_java;
import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public Connection DatabaseLink;

    public Connection getConnection() {
        String DatabaseName = " java group";
        String DatabaseUser = "root";
        String DatabasePassword = "";
        String url = "jdbc:mysql://127.0.0.1:3306/" + DatabaseName ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            DatabaseLink = DriverManager.getConnection(url,DatabaseUser,DatabasePassword);


        }catch(Exception e ){
            e.printStackTrace();
            e.getCause();
        }
        return DatabaseLink;
    }
}
