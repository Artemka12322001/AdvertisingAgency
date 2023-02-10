package com.example.controller;

import com.example.service.RegistrationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationController extends Controller{

    @FXML
    private Button backButton;

    @FXML
    private TextField confirmationPasswordTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registrationButton;

    private final RegistrationService service = RegistrationService.getInstance();

    @FXML
    void initialize(){
        backButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/com/example/layout/authorization.fxml", backButton));
        registrationButton.setOnMouseClicked(mouseEvent -> registration());
    }

    private void registration(){
        String response = service.registration(loginTextField.getText(), passwordTextField.getText(), confirmationPasswordTextField.getText());
        switch (response) {
            case "passwords don't match" -> errorLabel.setText("Пароли не совпадают");
            case "name is empty" -> errorLabel.setText("Поле ФИО пустое");
            case "med info is empty" -> errorLabel.setText("Поле мед. справки пустое");
            case "phone is empty" -> errorLabel.setText("Поле телефона пустое");
            case "short phone" -> errorLabel.setText("Короткий телефон");
            case "long phone" -> errorLabel.setText("Длинный телефон");
            case "login is empty" -> errorLabel.setText("Поля логина пустое");
            case "password is empty" -> errorLabel.setText("Поля пароля пустое");
            case "short login" -> errorLabel.setText("Короткий логин");
            case "short password" -> errorLabel.setText("Короткий пароль");
            case "success" -> openOtherWindow(
                    "/com/example/layout/authorization.fxml", registrationButton);
            default -> errorLabel.setText("Ошибка");
        }
    }
}
