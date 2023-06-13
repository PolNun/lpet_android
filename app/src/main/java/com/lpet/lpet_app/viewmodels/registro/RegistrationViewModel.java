package com.lpet.lpet_app.viewmodels.registro;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.RegistrationModel;
import com.lpet.lpet_app.models.repositories.UserRepository;

public class RegistrationViewModel extends ViewModel {
    private MutableLiveData<RegistrationModel> registrationModelLiveData;
    private UserRepository userRepository;

    public RegistrationViewModel() {
        registrationModelLiveData = new MutableLiveData<>();
        userRepository = UserRepository.getInstance();
    }

    public LiveData<RegistrationModel> getRegistrationModelLiveData() {
        return registrationModelLiveData;
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
        if (registrationModel != null) {
            userRepository.registerUser(registrationModel);
        }
    }
}