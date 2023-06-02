package com.lpet.lpet_app.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> correoElectronicoLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> contrasenaLiveData = new MutableLiveData<>();

    private MutableLiveData<LoginModel> loginModelLivedata = new MutableLiveData<>();
    private LoginRepository loginRepository;

    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

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

    public boolean validarCredencialesLoginViewModel() {
        String correoElectronico = getCorreoElectronicoLiveData().getValue();
        String contrasena = getContrasenaLiveData().getValue();
        return loginRepository.validarCredencialesLoginRepository(correoElectronico, contrasena);
    }
}

//TODO Tomar estos atributos y relacionarlos con la clase LoginRepository
// TODO crear la logica de la clase LoginRepository
