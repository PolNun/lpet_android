package com.lpet.lpet_app.api.responsemodels;

public class RegistrationResponse {
    private String token;
    private String username;
    private String email;

    public RegistrationResponse(String token, String username, String email) {
        this.token = token;
        this.username = username;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
