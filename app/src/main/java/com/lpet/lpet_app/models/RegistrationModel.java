package com.lpet.lpet_app.models;

public class RegistrationModel {
    private String email;
    private String password;
    private String username;

    public RegistrationModel(String email, String password) {
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
        // Add email validation logic using regex if required
        return email != null && !email.isEmpty();
    }

    public boolean isValidPassword() {
        // Add password validation logic using regex if required
        return password != null && !password.isEmpty();
    }

    public boolean isValidUsername() {
        // Add username validation logic using regex if required
        return username != null && !username.isEmpty();
    }
}
