package com.example.service;

import com.example.entity.PrintedEducation;
import com.example.repository.DatabaseHandler;
import javafx.collections.ObservableList;

public class GuideService {
    private static final GuideService GUIDE_SERVICE = new GuideService();

    private GuideService() {
    }

    public static GuideService getInstance() {
        return GUIDE_SERVICE;
    }

    private final DatabaseHandler databaseHandler = DatabaseHandler.getInstance();


    public ObservableList<PrintedEducation> getPrintedEducations() {
        return databaseHandler.findAllPrintedEducation();
    }
}
