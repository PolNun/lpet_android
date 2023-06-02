package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.utils.BBDDUsuarios;

public class LoginRepository {
    private BBDDUsuarios bbddUsuarios;

    public LoginRepository() {
        bbddUsuarios = new BBDDUsuarios();
    }

    public void loginUser(String email, String password, LoginCallback callback) {
        boolean success = bbddUsuarios.checkLoginCredentials(email, password);
        if (success) {
            callback.onLoginSuccess();
        } else {
            callback.onLoginFailure("Invalid credentials");
        }
    }

    public interface LoginCallback {
        void onLoginSuccess();

        void onLoginFailure(String errorMessage);
    }
}
