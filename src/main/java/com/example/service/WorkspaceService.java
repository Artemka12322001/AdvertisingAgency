package com.example.service;

import com.example.dto.RequestForTable;
import com.example.entity.Advertiser;
import com.example.entity.PrintedEducation;
import com.example.entity.Request;
import com.example.repository.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkspaceService {
    private static final WorkspaceService WORKSPACE_SERVICE = new WorkspaceService();

    private WorkspaceService() {
    }

    public static WorkspaceService getInstance() {
        return WORKSPACE_SERVICE;
    }

    private final DatabaseHandler databaseHandler = DatabaseHandler.getInstance();

    public ObservableList<RequestForTable> getRequestForTable() {
        ObservableList<RequestForTable> requestsForTable = FXCollections.observableArrayList();

        try {
            ObservableList<Request> requests = databaseHandler.findAllRequest();
            ObservableList<Advertiser> advertisers = databaseHandler.findAllAdvertiser();
            ObservableList<PrintedEducation> printedEducations = databaseHandler.findAllPrintedEducation();

            for (Advertiser advertiser : advertisers) {
                RequestForTable requestForTable = new RequestForTable();
                PrintedEducation printedEducation = printedEducations.stream().filter(
                        pe -> pe.getId().equals(advertiser.getPrintedEducationId())).findFirst().get();
                Request request = requests.stream().filter(
                        r -> r.getId().equals(advertiser.getRequestId())).findFirst().get();

                requestForTable.setAdvertiserName(advertiser.getName());
                requestForTable.setPrintedEducationName(printedEducation.getName());
                requestForTable.setPrice(
                        request.getNumberOfIssues() * Integer.parseInt(request.getSize()) * printedEducation.getPriceAdvertising());


                requestsForTable.add(requestForTable);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return requestsForTable;
    }
}
