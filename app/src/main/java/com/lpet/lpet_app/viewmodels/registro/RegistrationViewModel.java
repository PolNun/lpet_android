package com.lpet.lpet_app.viewmodels.registro;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.api.responsemodels.RegistrationResponse;
import com.lpet.lpet_app.models.User;
import com.lpet.lpet_app.models.repositories.LoginRepository;

public class RegistrationViewModel extends ViewModel {
    private final MutableLiveData<User> registrationModelLiveData;
//    private final RegistrationRepository registrationRepository;

    public RegistrationViewModel() {
        registrationModelLiveData = new MutableLiveData<>();
//        registrationRepository = new RegistrationRepository();
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

//    public void register(final RegistrationCallback callback) {
//        User registrationModel = registrationModelLiveData.getValue();
//        if (registrationModel != null) {
//            userRepository.registerUser(registrationModel, new UserRepository.RegistrationCallback() {
//
//                @Override
//                public void onRegistrationSuccess(RegistrationResponse registrationResponse) {
//                    // Handle registration success
//                    callback.onRegistrationSuccess();
//                }
//
//                @Override
//                public void onRegistrationFailure(String errorMessage) {
//                    // Handle registration failure
//                    callback.onRegistrationFailure(errorMessage);
//                }
//            });
//        }
//    }

    public interface RegistrationCallback {
        void onRegistrationSuccess();

        void onRegistrationFailure(String errorMessage);
    }
}
