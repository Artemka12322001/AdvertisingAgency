package com.example.controller;

import com.example.service.AuthorizationService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AuthorizationController extends Controller {
    AuthorizationService service = AuthorizationService.getInstance();
    @FXML
    private Label errorLabel;
    @FXML
    private ImageView logoImageView;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {
        registrationButton.setOnAction(actionEvent -> openOtherWindow(
                "/com/example/layout/registration.fxml", registrationButton));
        passwordTextField.setOnAction(actionEvent -> authorization());
        errorLabel.setOnMouseClicked(mouseEvent -> authorization());
        logoImageView.setOnMouseClicked(mouseEvent -> authorization());
    }

    private void authorization() {
        String response = service.authorization(loginTextField.getText(), passwordTextField.getText());
        switch (response) {
            case "login is empty" -> errorLabel.setText("Поле логина пустое");
            case "short login" -> errorLabel.setText("Короткий логин");
            case "password is empty" -> errorLabel.setText("Поле пароля пустое");
            case "short password" -> errorLabel.setText("Короткий пароль");
            case "user not found" -> errorLabel.setText("Пользователь не найден");
            case "incorrect password" -> errorLabel.setText("Неверный пароль");
            case "success" -> openOtherWindow("/com/example/layout/workspace.fxml", passwordTextField);
            default -> errorLabel.setText("Ошибка");
        }
    }
}
