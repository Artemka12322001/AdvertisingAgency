module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example to javafx.fxml;
    exports com.example;
    opens com.example.controller to javafx.fxml;
    exports com.example.controller;
    opens com.example.entity to javafx.fxml;
    exports com.example.entity;
    opens com.example.dto to javafx.fxml;
    exports com.example.dto;
}