package com.lpet.lpet_app.viewmodels.login;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.api.responsemodels.ErrorResponse;
import com.lpet.lpet_app.api.responsemodels.LoginResponse;
import com.lpet.lpet_app.models.Login;
import com.lpet.lpet_app.models.repositories.LoginRepository;
import com.lpet.lpet_app.utils.FieldValidator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final LoginRepository loginRepository;

    private final MutableLiveData<Boolean> isLoading;
    private final MutableLiveData<String> loginResult;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
        isLoading = new MutableLiveData<>();
        loginResult = new MutableLiveData<>();
    }

    public LiveData<Boolean> isLoading() {
        return isLoading;
    }

    public LiveData<String> getLoginResult() {
        return loginResult;
    }

    public void login(String email, String password) {
        isLoading.setValue(true);

        Login login = new Login(email, password);
        loginRepository.login(login, new LoginRepository.LoginCallback() {
            @Override
            public void onLoginSuccess(LoginResponse loginResponse) {
                isLoading.setValue(false);
                loginResult.setValue("Login successful");
                // Perform any additional actions upon successful login
            }

            @Override
            public void onLoginFailure(ErrorResponse errorMessage) {
                isLoading.setValue(false);
                loginResult.setValue("Login failed: " + errorMessage.getMessage());
                System.out.println("Login failed: " + errorMessage.getMessage());
                // Perform any additional actions upon login failure
            }
        });
    }
}
