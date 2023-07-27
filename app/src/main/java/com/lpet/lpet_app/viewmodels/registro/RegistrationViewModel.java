package com.lpet.lpet_app.viewmodels.registro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.api.responsemodels.ErrorResponse;
import com.lpet.lpet_app.api.responsemodels.RegistrationResponse;
import com.lpet.lpet_app.models.User;
import com.lpet.lpet_app.models.repositories.RegistrationRepository;

public class RegistrationViewModel extends ViewModel {
    private final MutableLiveData<User> registrationModelLiveData;
    private final MutableLiveData<Boolean> isLoading;
    private final MutableLiveData<String> registrationResult;

    private final RegistrationRepository registrationRepository;

    public RegistrationViewModel() {
        registrationModelLiveData = new MutableLiveData<>();
        isLoading = new MutableLiveData<>();
        registrationResult = new MutableLiveData<>();
        registrationRepository = new RegistrationRepository();
    }

    public LiveData<Boolean> isLoading() {
        return isLoading;
    }

    public LiveData<String> getRegistrationResult() {
        return registrationResult;
    }

    public void saveStep1Data(String email, String password) {
        User registrationModel = new User(email, password);
        registrationModelLiveData.setValue(registrationModel);
    }

    public void saveStep2Data(String username) {
        User registrationModel = registrationModelLiveData.getValue();
        if (registrationModel != null) {
            registrationModel.setUsername(username);
            registrationModelLiveData.setValue(registrationModel);
        }
    }

    public void register() {
        isLoading.setValue(true);
        User registrationModel = registrationModelLiveData.getValue();
//        if (registrationModel == null) {
//            isLoading.setValue(false);
//            registrationResult.setValue("Datos de registro incompletos");
//            return;
//        }
//
//        if (!registrationModel.isValidEmail()) {
//            isLoading.setValue(false);
//            registrationResult.setValue("Email inválido");
//            return;
//        }
//
//        if (!registrationModel.isValidPassword()) {
//            isLoading.setValue(false);
//            registrationResult.setValue("Contraseña inválida");
//            return;
//        }
//
//        if (!registrationModel.isValidUsername()) {
//            isLoading.setValue(false);
//            registrationResult.setValue("Nombre de usuario inválido");
//            return;
//        }

        registrationRepository.register(registrationModel, new RegistrationRepository.RegistrationCallback() {
            @Override
            public void onRegistrationSuccess(RegistrationResponse registrationResponse) {
                isLoading.setValue(false);
                registrationResult.setValue("Registration successful");
            }

            @Override
            public void onRegistrationFailure(ErrorResponse errorMessage) {
                isLoading.setValue(false);
                registrationResult.setValue("Fallo al registrar: " + errorMessage.getMessage());
            }
        });
    }
}
