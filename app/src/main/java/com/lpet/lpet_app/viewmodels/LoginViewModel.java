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
        if (isValidEmail(email) && isValidPassword(password)) {
            loginRepository.loginUser(email, password, new LoginRepository.LoginCallback() {
                @Override
                public void onLoginSuccess() {
                    loginSuccessLiveData.setValue(true);
                }

                @Override
                public void onLoginFailure(String errorMessage) {
                    loginSuccessLiveData.setValue(false);
                }
            });
        } else {
            loginSuccessLiveData.setValue(false);
        }
    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic using regex or any other approach
        // Return true if email is valid, false otherwise
        return true;
    }

    private boolean isValidPassword(String password) {
        // Implement password validation logic using regex or any other approach
        // Return true if password is valid, false otherwise
        return true;
    }
}
