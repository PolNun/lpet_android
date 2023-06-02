package com.lpet.lpet_app.utils;

import com.lpet.lpet_app.models.LoginModel;

import java.util.ArrayList;
import java.util.List;

public class BBDDUsuarios {

    private static final List<LoginModel> loginModelList;

    static {
        loginModelList = new ArrayList<>();
        loginModelList.add(new LoginModel("user1@example.com", "password1"));
        loginModelList.add(new LoginModel("user2@example.com", "password2"));
    }

    public static List<LoginModel> getLoginModelList() {
        return loginModelList;
    }

    public static void addLoginModel(LoginModel loginModel) {
        loginModelList.add(loginModel);
    }
}
