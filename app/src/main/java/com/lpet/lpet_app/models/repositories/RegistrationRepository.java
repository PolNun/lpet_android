package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.api.ApiClient;
import com.lpet.lpet_app.api.ApiService;
import com.lpet.lpet_app.api.responsemodels.ErrorResponse;
import com.lpet.lpet_app.api.responsemodels.RegistrationResponse;
import com.lpet.lpet_app.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationRepository {
    private final ApiService apiService;

    public RegistrationRepository() {
        apiService = ApiClient.getClient();
    }

    public void register(User user, final RegistrationCallback callback) {
        Call<RegistrationResponse> call = apiService.registration(user);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if (response.isSuccessful()) {
                    RegistrationResponse registrationResponse = response.body();
                    callback.onRegistrationSuccess(registrationResponse);
                } else {
                    ErrorResponse errorResponse = new ErrorResponse(response.message());
                    callback.onRegistrationFailure(errorResponse);
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                String errorMessage = "Registration request failed due to network error: " + t.getMessage();
                callback.onRegistrationFailure(new ErrorResponse(errorMessage));
            }
        });
    }

    public interface RegistrationCallback {
        void onRegistrationSuccess(RegistrationResponse registrationResponse);

        void onRegistrationFailure(ErrorResponse errorMessage);
    }
}
