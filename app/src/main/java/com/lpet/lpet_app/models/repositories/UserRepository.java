package com.lpet.lpet_app.models.repositories;

import androidx.annotation.NonNull;

import com.lpet.lpet_app.api.ApiClient;
import com.lpet.lpet_app.api.ApiService;
import com.lpet.lpet_app.api.responsemodels.LoginResponse;
import com.lpet.lpet_app.api.responsemodels.RegistrationResponse;
import com.lpet.lpet_app.models.Login;
import com.lpet.lpet_app.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository instance;
    private final ApiService apiService;

    private UserRepository() {
        apiService = ApiClient.getClient();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void registerUser(User user, final RegistrationCallback callback) {
        Call<RegistrationResponse> registrationCall = apiService.register(user);
        registrationCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call, @NonNull Response<RegistrationResponse> response) {
                if (response.isSuccessful()) {
                    RegistrationResponse registrationResponse = response.body();
                    callback.onRegistrationSuccess(registrationResponse);
                } else {
                    // Handle API error response
                    callback.onRegistrationFailure("Registration failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                // Handle network or other errors
                callback.onRegistrationFailure("Network error");
            }
        });
    }

    public void loginUser(String email, String password, final LoginCallback callback) {
        Login login = new Login(email, password);

        Call<LoginResponse> loginCall = apiService.login(login);
        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    callback.onLoginSuccess(loginResponse);
                } else {
                    // Handle API error response
                    System.out.println(response.errorBody());
                    callback.onLoginFailure("Login failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                // Handle network or other errors
                callback.onLoginFailure("Network error");
            }
        });
    }

    public interface RegistrationCallback {
        void onRegistrationSuccess(RegistrationResponse registrationResponse);

        void onRegistrationFailure(String errorMessage);
    }

    public interface LoginCallback {
        void onLoginSuccess(LoginResponse loginResponse);

        void onLoginFailure(String errorMessage);
    }
}