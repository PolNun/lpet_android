package com.lpet.lpet_app.api;

import com.lpet.lpet_app.api.responsemodels.LoginResponse;
import com.lpet.lpet_app.api.responsemodels.RegistrationResponse;
import com.lpet.lpet_app.models.Login;
import com.lpet.lpet_app.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("users/login")
    Call<LoginResponse> login(@Body Login login);
}
