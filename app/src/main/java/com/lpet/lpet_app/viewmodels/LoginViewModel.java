package com.lpet.lpet_app.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.models.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<Boolean> loginSuccessLiveData = new MutableLiveData<>();
    private final LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    public LiveData<Boolean> getLoginSuccessLiveData() {
        return loginSuccessLiveData;
    }

    public void login(String email, String password) {
        LoginModel loginModel = new LoginModel(email, password);

        if (loginModel.isValid()) {
            loginRepository.login(loginModel, new LoginRepository.LoginCallback() {
                @Override
                public void onSuccess() {
                    loginSuccessLiveData.setValue(true);
                }

                @Override
                public void onFailure() {
                    loginSuccessLiveData.setValue(false);
                }
            });
        } else {
            loginSuccessLiveData.setValue(false);
        }
    }
}
