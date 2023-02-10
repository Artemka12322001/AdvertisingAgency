package com.example.controller;

import com.example.entity.PrintedEducation;
import com.example.service.GuideService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GuideController extends Controller {

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<PrintedEducation, String> nameTableColumn;

    @FXML
    private TableColumn<PrintedEducation, String> priceTableColumn;

    @FXML
    private TableColumn<PrintedEducation, String> typeTableColumn;

    @FXML
    private TableView<PrintedEducation> printedEducationTableView;

    GuideService service = GuideService.getInstance();

    @FXML
    void initialize(){
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceTableColumn.setCellValueFactory(new PropertyValueFactory<>("priceAdvertising"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeAdvertising"));

        exitButton.setOnMouseClicked(mouseEvent ->  openOtherWindow(
                "/com/example/layout/workspace.fxml", exitButton));

        printedEducationTableView.setItems(service.getPrintedEducations());
    }
}
