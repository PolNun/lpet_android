package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.api.ApiClient;
import com.lpet.lpet_app.api.ApiService;
import com.lpet.lpet_app.api.responsemodels.ErrorResponse;
import com.lpet.lpet_app.api.responsemodels.LoginResponse;
import com.lpet.lpet_app.models.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private final ApiService apiService;

    public LoginRepository() {
        apiService = ApiClient.getClient();
    }

    public void login(Login login, final LoginCallback callback) {

        Call<LoginResponse> call = apiService.login(login);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    callback.onLoginSuccess(loginResponse);
                } else {
                    ErrorResponse errorResponse = new ErrorResponse(response.message());
                    callback.onLoginFailure(errorResponse);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String errorMessage = "Login request failed due to network error: " + t.getMessage();
                callback.onLoginFailure(new ErrorResponse(errorMessage));
            }
        });
    }

    public interface LoginCallback {
        void onLoginSuccess(LoginResponse loginResponse);

        void onLoginFailure(ErrorResponse errorMessage);
    }
}
