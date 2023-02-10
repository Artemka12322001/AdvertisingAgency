package com.example.service;


import com.example.repository.DatabaseHandler;

public class RegistrationService {
    private static final RegistrationService REGISTRATION_SERVICE = new RegistrationService();

    private RegistrationService() {
    }

    public static RegistrationService getInstance() {
        return REGISTRATION_SERVICE;
    }

    private final DatabaseHandler databaseHandler = DatabaseHandler.getInstance();

    public String registration(String login, String password, String confirmationPassword) {
        if (!confirmationPassword.equals(password))
            return "passwords don't match";
        if (login.equals(""))
            return "login is empty";
        if (password.equals(""))
            return "password is empty";
        if (login.length() < 3)
            return "short login";
        if (password.length() < 3)
            return "short password";

        try {
            return databaseHandler.registration(login, password);
        } catch (Exception exception) {
            return "error";
        }
    }
}
