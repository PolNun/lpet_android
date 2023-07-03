package com.lpet.lpet_app.utils;

import com.lpet.lpet_app.models.Login;
import com.lpet.lpet_app.models.User;

import java.util.ArrayList;
import java.util.List;

public class BBDDUsuarios {
    private List<Login> loginModels;
    private List<User> registrationModels;

    public BBDDUsuarios() {
        loginModels = new ArrayList<>();
        registrationModels = new ArrayList<>();
    }

    public void addLoginModel(Login loginModel) {
        loginModels.add(loginModel);
    }

    public boolean checkLoginCredentials(String email, String password) {
        for (Login loginModel : loginModels) {
            if (loginModel.getEmail().equals(email) && loginModel.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addRegistrationModel(User registrationModel) {
        registrationModels.add(registrationModel);
    }

    public boolean isEmailRegistered(String email) {
        for (User registrationModel : registrationModels) {
            if (registrationModel.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUsernameTaken(String username) {
        for (User registrationModel : registrationModels) {
            if (registrationModel.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
