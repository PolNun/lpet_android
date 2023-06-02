package com.lpet.lpet_app.utils;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.models.RegistrationModel;

import java.util.ArrayList;
import java.util.List;

public class BBDDUsuarios {
    private List<LoginModel> loginModels;
    private List<RegistrationModel> registrationModels;

    public BBDDUsuarios() {
        loginModels = new ArrayList<>();
        registrationModels = new ArrayList<>();
    }

    public void addLoginModel(LoginModel loginModel) {
        loginModels.add(loginModel);
    }

    public boolean checkLoginCredentials(String email, String password) {
        for (LoginModel loginModel : loginModels) {
            if (loginModel.getEmail().equals(email) && loginModel.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addRegistrationModel(RegistrationModel registrationModel) {
        registrationModels.add(registrationModel);
    }

    public boolean isEmailRegistered(String email) {
        for (RegistrationModel registrationModel : registrationModels) {
            if (registrationModel.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUsernameTaken(String username) {
        for (RegistrationModel registrationModel : registrationModels) {
            if (registrationModel.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
