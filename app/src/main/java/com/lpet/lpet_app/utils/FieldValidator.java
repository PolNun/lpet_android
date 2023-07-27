package com.lpet.lpet_app.utils;

public class FieldValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._-]{3,50}@[a-zA-Z0-9.-]{3,50}\\.[a-zA-Z]{2,4}$";
    private static final String PASSWORD_REGEX = "^[ -~]{8,30}$";
    private static final String USERNAME_REGEX = "^[A-Za-zÀ-ÿ0-9\\s,'-.():\"`~]{1,50}$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public static boolean isValidRepeatPassword(String password, String repeatPassword) {
        return password.equals(repeatPassword);
    }
}
