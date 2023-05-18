package com.lpet.lpet_app.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.views.login.LoginFragment;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> correoElectronicoLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> contrasenaLiveData = new MutableLiveData<>();

    private MutableLiveData<LoginModel> loginModelLivedata = new MutableLiveData<>();


    public LiveData<String> getCorreoElectronicoLiveData() {
        return correoElectronicoLiveData;
    }

    public LiveData<String> getContrasenaLiveData() {
        return contrasenaLiveData;
    }

    public void setCorreoElectronico(String correoElectronico) {
        correoElectronicoLiveData.setValue(correoElectronico);
    }

    public void setContrasena(String contrasena) {
        contrasenaLiveData.setValue(contrasena);
    }

    public void setLoginModel(LoginModel loginModel) {
        loginModelLivedata.setValue(loginModel);
    }
}

//TODO Tomar estos atributos y relacionarlos con la clase LoginRepository
// TODO crear la logica de la clase LoginRepository
