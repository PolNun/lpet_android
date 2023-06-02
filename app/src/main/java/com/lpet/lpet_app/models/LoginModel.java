package com.lpet.lpet_app.models;

public class LoginModel {
    private String email;
    private String password;

    public LoginModel() {
    }

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        // Perform email and password validation
        return isValidEmail(email) && isValidPassword(password);
    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        // Implement password validation logic
        return password.length() >= 6;
    }
}