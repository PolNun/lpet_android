package com.lpet.lpet_app.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> correoElectronicoLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> contrasenaLiveData = new MutableLiveData<>();

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

}
