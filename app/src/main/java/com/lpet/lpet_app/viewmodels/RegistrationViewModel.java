package com.lpet.lpet_app.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.RegistrationModel;
import com.lpet.lpet_app.models.repositories.RegistrationRepository;

public class RegistrationViewModel extends ViewModel {

    private final MutableLiveData<RegistrationModel> registrationModelLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registrationSuccessLiveData = new MutableLiveData<>();
    private final RegistrationRepository registrationRepository;

    public RegistrationViewModel() {
        registrationRepository = new RegistrationRepository();
    }

    public LiveData<RegistrationModel> getRegistrationModelLiveData() {
        return registrationModelLiveData;
    }

    public LiveData<Boolean> getRegistrationSuccessLiveData() {
        return registrationSuccessLiveData;
    }

    public void saveStep1Data(String email, String password) {
        RegistrationModel registrationModel = new RegistrationModel(email, password);
        registrationModelLiveData.setValue(registrationModel);
    }

    public void saveStep2Data(String username) {
        RegistrationModel registrationModel = registrationModelLiveData.getValue();
        if (registrationModel != null) {
            registrationModel.setUsername(username);
            registrationModelLiveData.setValue(registrationModel);
        }
    }

    public void register() {
        RegistrationModel registrationModel = registrationModelLiveData.getValue();
        if (registrationModel != null && registrationModel.isStep2Complete()) {
            String email = registrationModel.getEmail();
            String password = registrationModel.getPassword();
            String username = registrationModel.getUsername();

            registrationRepository.registerUser(email, password, username, new RegistrationRepository.RegistrationCallback() {
                @Override
                public void onRegistrationSuccess() {
                    registrationSuccessLiveData.setValue(true);
                }

                @Override
                public void onRegistrationFailure(String errorMessage) {
                    registrationSuccessLiveData.setValue(false);
                }
            });
        } else {
            registrationSuccessLiveData.setValue(false);
        }
    }
}