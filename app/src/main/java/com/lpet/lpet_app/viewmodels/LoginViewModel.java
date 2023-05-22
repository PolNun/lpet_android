package com.lpet.lpet_app.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {
    // ATRIBUTOS
    private final MutableLiveData<String> correoElectronicoLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> contrasenaLiveData = new MutableLiveData<>();
    private MutableLiveData<LoginModel> loginModelLivedata = new MutableLiveData<>();
    private LoginRepository loginRepository;

    // METODOS
    //METODO CONSTRUCTOR
    public LoginViewModel() {
        loginRepository = new LoginRepository();
    }

    // METODOS GETTERS
    public LiveData<String> getCorreoElectronicoLiveData() {
        return correoElectronicoLiveData;
    }

    public LiveData<String> getContrasenaLiveData() {
        return contrasenaLiveData;
    }

    //METODOS SETTERS
    public void setCorreoElectronico(String correoElectronico) {
        correoElectronicoLiveData.setValue(correoElectronico);
    }

    public void setContrasena(String contrasena) {
        contrasenaLiveData.setValue(contrasena);
    }

    public void setLoginModel(LoginModel loginModel) {
        loginModelLivedata.setValue(loginModel);
    }

    //METODO validarCredencialesLoginViewModel
    public boolean validarCredencialesLoginViewModel() {
        return loginRepository.validarCredencialesLoginRepository(getCorreoElectronicoLiveData().getValue(), getContrasenaLiveData().getValue());
    }
}



