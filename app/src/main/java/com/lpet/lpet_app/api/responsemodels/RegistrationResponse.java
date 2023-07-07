package com.lpet.lpet_app.api.responsemodels;

public class RegistrationResponse {
    private Long id;
    private String email;
    private String username;

    public RegistrationResponse() {
    }

    public RegistrationResponse(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
