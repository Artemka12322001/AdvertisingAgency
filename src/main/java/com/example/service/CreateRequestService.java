package com.example.service;

import com.example.entity.Advertiser;
import com.example.entity.PrintedEducation;
import com.example.entity.Request;
import com.example.repository.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CreateRequestService {
    private static final CreateRequestService CREATE_REQUEST_SERVICE = new CreateRequestService();

    private CreateRequestService() {
    }

    public static CreateRequestService getInstance() {
        return CREATE_REQUEST_SERVICE;
    }

    private final DatabaseHandler databaseHandler = DatabaseHandler.getInstance();


    public ObservableList<String> getAdvertiseTypes() {
        ObservableList<String> types = FXCollections.observableArrayList();
        try {
            types.add("Модульная");
            types.add("Рубричная");
            types.add("Текстовая");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return types;
    }

    public ObservableList<String> getPrintedEducations() {
        ObservableList<String> names = FXCollections.observableArrayList();

        try {
            ObservableList<PrintedEducation> printedEducations = databaseHandler.findAllPrintedEducation();
            for (PrintedEducation printedEducation : printedEducations) {
                names.add(printedEducation.getName());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return names;
    }

    public boolean createRequest(String advertiseType, String printedEducationName, String size,
                                 String numberOfIssues, String additionalInformation,
                                 String advertiserName, String address, String director,
                                 String phone, String adPlacementLocation) {
        try {
            Request request = new Request();
            request.setId(databaseHandler.generateNewId("request", "request_id"));
            request.setSize(size);
            request.setType(advertiseType);
            request.setPrintedEducationId(
                    databaseHandler.findAllPrintedEducation().stream().filter(printedEducation ->
                            printedEducation.getName().equals(printedEducationName)).findFirst().get().getId());
            request.setNumberOfIssues(Integer.parseInt(numberOfIssues));
            request.setAdditionalInformation(additionalInformation);

            Advertiser advertiser = new Advertiser();
            advertiser.setId(databaseHandler.generateNewId("advertiser", "advertiser_id"));
            advertiser.setName(advertiserName);
            advertiser.setAddress(address);
            advertiser.setPhone(phone);
            advertiser.setDirector(director);
            advertiser.setRequestId(request.getId());
            advertiser.setPayment("true");
            advertiser.setPrintedEducationId(
                    databaseHandler.findAllPrintedEducation().stream().filter(printedEducation ->
                            printedEducation.getName().equals(printedEducationName)).findFirst().get().getId());
            advertiser.setAdPlacementLocation(adPlacementLocation);

            databaseHandler.insertRequest(request);
            databaseHandler.insertAdvertiser(advertiser);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
