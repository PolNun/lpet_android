package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.models.RegistrationModel;
import com.lpet.lpet_app.utils.BBDDUsuarios;

public class RegistrationRepository {
    private BBDDUsuarios bbddUsuarios;

    public RegistrationRepository() {
        bbddUsuarios = new BBDDUsuarios();
    }

    public void registerUser(String email, String password, String username, RegistrationCallback callback) {
        boolean emailExists = bbddUsuarios.isEmailRegistered(email);
        boolean usernameTaken = bbddUsuarios.isUsernameTaken(username);

        if (emailExists) {
            callback.onRegistrationFailure("Email already registered");
        } else if (usernameTaken) {
            callback.onRegistrationFailure("Username already taken");
        } else {
            RegistrationModel registrationModel = new RegistrationModel(email, password);
            registrationModel.setUsername(username);
            bbddUsuarios.addRegistrationModel(registrationModel);
            callback.onRegistrationSuccess();
        }
    }

    public interface RegistrationCallback {
        void onRegistrationSuccess();

        void onRegistrationFailure(String errorMessage);
    }
}