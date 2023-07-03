package com.lpet.lpet_app.models;

import androidx.annotation.NonNull;

import com.lpet.lpet_app.utils.FieldValidator;

public class User {
    private String email;
    private String password;
    private String username;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStep1Complete() {
        return email != null && !email.isEmpty() && password != null && !password.isEmpty();
    }

    public boolean isStep2Complete() {
        return isStep1Complete() && username != null && !username.isEmpty();
    }

    public boolean isValidEmail() {
        return FieldValidator.isValidEmail(email);
    }

    public boolean isValidPassword() {
        return FieldValidator.isValidPassword(password);
    }

    public boolean isValidUsername() {
        return FieldValidator.isValidUsername(username);
    }

    @NonNull
    @Override
    public String toString() {
        return "RegistrationModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
