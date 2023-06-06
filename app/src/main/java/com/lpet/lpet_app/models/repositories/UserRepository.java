package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.models.RegistrationModel;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository instance;
    private ArrayList<RegistrationModel> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void registerUser(RegistrationModel registrationModel) {
        users.add(registrationModel);
    }

    public void loginUser(String email, String password, LoginCallback callback) {
        for (RegistrationModel user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                callback.onLoginSuccess();
                return;
            }
        }
        callback.onLoginFailure("Invalid email or password");
    }

    public interface LoginCallback {
        void onLoginSuccess();

        void onLoginFailure(String errorMessage);
    }
}
