package com.lpet.lpet_app.utils;

public class FieldValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._-]{3,50}@[a-zA-Z0-9.-]{3,50}\\.[a-zA-Z]{2,4}$";
    private static final String PASSWORD_REGEX = "[a-zA-Z\\d]{8,30}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9_-]{5,15}$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }
}
