package com.lpet.lpet_app.models.repositories;

import android.os.Handler;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.utils.BBDDUsuarios;

import java.util.List;

public class LoginRepository {
    public void login(LoginModel loginModel, LoginCallback callback) {
        if (isValidCredentials(loginModel)) {
            callback.onSuccess();
        } else {
            callback.onFailure();
        }
    }

    private boolean isValidCredentials(LoginModel loginModel) {
        List<LoginModel> loginModelList = BBDDUsuarios.getLoginModelList();
        for (LoginModel model : loginModelList) {
            if (model.getEmail().equals(loginModel.getEmail()) && model.getPassword().equals(loginModel.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public interface LoginCallback {
        void onSuccess();

        void onFailure();
    }
}
