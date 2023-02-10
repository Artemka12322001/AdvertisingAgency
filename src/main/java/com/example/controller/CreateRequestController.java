package com.example.controller;

import com.example.service.CreateRequestService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateRequestController extends Controller {
    @FXML
    private Button acceptButton;

    @FXML
    private TextField adPlacementLocationTextField;

    @FXML
    private TextField additionalInformationTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private ComboBox<String> advertiseTypeComboBox;

    @FXML
    private TextField advertiserNameTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField directorTextField;

    @FXML
    private TextField numberOfIssuesTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private ComboBox<String> printedEducationComboBox;

    @FXML
    private TextField sizeTextField;

    private final CreateRequestService service = CreateRequestService.getInstance();

    @FXML
    void initialize() {
        advertiseTypeComboBox.setItems(service.getAdvertiseTypes());
        printedEducationComboBox.setItems(service.getPrintedEducations());

        cancelButton.setOnMouseClicked(mouseEvent -> openOtherWindow(
                "/com/example/layout/workspace.fxml", cancelButton));

        acceptButton.setOnMouseClicked(mouseEvent -> {
            if (service.createRequest(advertiseTypeComboBox.getValue(), printedEducationComboBox.getValue(),
                    sizeTextField.getText(), numberOfIssuesTextField.getText(),
                    additionalInformationTextField.getText(), advertiserNameTextField.getText(),
                    addressTextField.getText(), directorTextField.getText(), phoneTextField.getText(),
                    adPlacementLocationTextField.getText())) {
                openOtherWindow("/com/example/layout/workspace.fxml", cancelButton);}
        });
    }
}
