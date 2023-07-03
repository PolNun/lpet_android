package com.lpet.lpet_app.viewmodels.login;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.api.responsemodels.LoginResponse;
import com.lpet.lpet_app.models.repositories.UserRepository;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<Boolean> loginSuccessLiveData = new MutableLiveData<>();
    private final UserRepository userRepository;

    public LoginViewModel() {
        userRepository = UserRepository.getInstance();
    }

    public LiveData<Boolean> getLoginSuccessLiveData() {
        return loginSuccessLiveData;
    }

    public void login(String email, String password) {
        if (isValidEmail(email) && isValidPassword(password)) {
            userRepository.loginUser(email, password, new UserRepository.LoginCallback() {

                @Override
                public void onLoginSuccess(LoginResponse loginResponse) {
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