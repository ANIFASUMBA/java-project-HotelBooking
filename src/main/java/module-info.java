module com.three.project_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    opens com.three.project_java to javafx.fxml;
    exports com.three.project_java;








}