package com.example.repository;

import com.example.entity.Advertiser;
import com.example.entity.PrintedEducation;
import com.example.entity.Request;
import com.example.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler {
    private static final DatabaseHandler databaseHandler = new DatabaseHandler();

    private DatabaseHandler() {
        String connectionString = "jdbc:postgresql://localhost:5432/advertising_agency";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            dbConnection = DriverManager.getConnection(connectionString, "postgres", "890123890123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DatabaseHandler getInstance() {
        return databaseHandler;
    }

    final Connection dbConnection;

    public User authorization(String login, String password) throws Exception {
        String request = "select * from advertising_user where login = ? and password = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            throw new Exception();
        }
        User user = new User();
        user.setId(resultSet.getLong("advertising_user_id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }

    public String registration(String login, String password) {
        try {
            String request = "insert into advertising_user (advertising_user_id, login, password) values(?,?,?)";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            preparedStatement.setLong(1, generateNewId("advertising_user", "advertising_user_id"));
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return "error";
        }
        return "success";
    }

    public ObservableList<Request> findAllRequest() {
        ObservableList<Request> requests = FXCollections.observableArrayList();
        try {
            String request = "select * from request";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Request requestObj = new Request();
                requestObj.setId(resultSet.getLong("request_id"));
                requestObj.setType(resultSet.getString("type"));
                requestObj.setSize(resultSet.getString("size"));
                requestObj.setPrintedEducationId(resultSet.getLong("printed_edition_id"));
                requestObj.setNumberOfIssues(resultSet.getInt("number_of_issues"));
                requestObj.setAdditionalInformation(resultSet.getString("additional_information"));

                requests.add(requestObj);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return requests;
    }

    public ObservableList<Advertiser> findAllAdvertiser() {
        ObservableList<Advertiser> advertisers = FXCollections.observableArrayList();
        try {
            String request = "select * from advertiser";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertiser advertiser = new Advertiser();
                advertiser.setId(resultSet.getLong("advertiser_id"));
                advertiser.setName(resultSet.getString("name"));
                advertiser.setAddress(resultSet.getString("address"));
                advertiser.setDirector(resultSet.getString("director"));
                advertiser.setPhone(resultSet.getString("phone"));
                advertiser.setRequestId(resultSet.getLong("request_id"));
                advertiser.setPayment(resultSet.getString("payment"));
                advertiser.setPrintedEducationId(resultSet.getLong("printed_edition_id"));
                advertiser.setAdPlacementLocation(resultSet.getString("ad_placement_location"));

                advertisers.add(advertiser);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return advertisers;
    }

    public ObservableList<PrintedEducation> findAllPrintedEducation() {
        ObservableList<PrintedEducation> printedEducations = FXCollections.observableArrayList();
        try {
            String request = "select * from printed_edition";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PrintedEducation printedEducation = new PrintedEducation();
                printedEducation.setId(resultSet.getLong("printed_edition_id"));
                printedEducation.setName(resultSet.getString("name"));
                printedEducation.setTypeAdvertising(resultSet.getString("type_advertising"));
                printedEducation.setPriceAdvertising(resultSet.getInt("price_advertising"));

                printedEducations.add(printedEducation);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return printedEducations;
    }

    public long generateNewId(String table, String id) throws SQLException {
        String request = "select " + id + " from " + table;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        ResultSet resultSet = preparedStatement.executeQuery();
        long newId = 0;
        try {
            while (resultSet.next()) {
                long thisId = Long.parseLong(resultSet.getString(id));
                if (newId < thisId) {
                    newId = thisId;
                }
            }
        } catch (Exception ignored) {
        }
        return ++newId;
    }

    public void insertRequest(Request request) throws SQLException {
        String bdRequest = "insert into request" +
                "(request_id, type, size, printed_edition_id, number_of_issues, additional_information)" +
                "values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(bdRequest);
        preparedStatement.setLong(1, request.getId());
        preparedStatement.setString(2, request.getType());
        preparedStatement.setString(3, request.getSize());
        preparedStatement.setLong(4, request.getPrintedEducationId());
        preparedStatement.setInt(5, request.getNumberOfIssues());
        preparedStatement.setString(6, request.getAdditionalInformation());
        preparedStatement.executeUpdate();
    }

    public void insertAdvertiser(Advertiser advertiser) throws SQLException {
        String request = "insert into advertiser" +
                "(advertiser_id, address, director, phone, request_id, payment, printed_edition_id, ad_placement_location, name)" +
                "values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(request);
        preparedStatement.setLong(1, advertiser.getId());
        preparedStatement.setString(2, advertiser.getAddress());
        preparedStatement.setString(3, advertiser.getDirector());
        preparedStatement.setString(4, advertiser.getPhone());
        preparedStatement.setLong(5, advertiser.getRequestId());
        preparedStatement.setString(6, advertiser.getPayment());
        preparedStatement.setLong(7, advertiser.getPrintedEducationId());
        preparedStatement.setString(8, advertiser.getAdPlacementLocation());
        preparedStatement.setString(9, advertiser.getName());

        preparedStatement.executeUpdate();
    }
}
