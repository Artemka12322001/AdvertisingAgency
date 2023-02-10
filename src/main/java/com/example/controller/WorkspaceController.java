package com.example.controller;

import com.example.dto.RequestForTable;
import com.example.service.WorkspaceService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkspaceController extends Controller {

    @FXML
    private Button exitButton;

    @FXML
    private Button guideButton;

    @FXML
    private Button newRequestButton;
    @FXML
    private TableColumn<RequestForTable, String> advertiserTableColumn;
    @FXML
    private TableColumn<RequestForTable, String> priceAdvertisingTableColumn;

    @FXML
    private TableColumn<RequestForTable, String> printedEditionTableColumn;

    @FXML
    private TableView<RequestForTable> requestTableView;

    private final WorkspaceService service = WorkspaceService.getInstance();

    @FXML
    void initialize(){
        advertiserTableColumn.setCellValueFactory(new PropertyValueFactory<>("advertiserName"));
        priceAdvertisingTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        printedEditionTableColumn.setCellValueFactory(new PropertyValueFactory<>("printedEducationName"));

        exitButton.setOnMouseClicked(mouseEvent ->  openOtherWindow(
                "/com/example/layout/authorization.fxml", exitButton));
        guideButton.setOnMouseClicked(mouseEvent ->  openOtherWindow(
                "/com/example/layout/guide.fxml", guideButton));
        newRequestButton.setOnMouseClicked(mouseEvent ->  openOtherWindow(
                "/com/example/layout/create_request.fxml", newRequestButton));

        requestTableView.setItems(service.getRequestForTable());
    }
}
