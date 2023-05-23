package com.lpet.lpet_app.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.RegistroModel;

public class RegistroViewModel extends ViewModel {
    private MutableLiveData<String> correo_electronico;
    private MutableLiveData<String> contrsena;
    private MutableLiveData<String> nombre_de_usuario;

    private MutableLiveData<RegistroModel> registroModel;

    public RegistroModel getRegistroModel() {
        String correoElectronicoRegistroModel = getCorreo_electronico().getValue();
        String contrasenaRegistroModel = getContrsena().getValue();
        String nombreDeUsuarioRegistroModel = getNombre_de_usuario().getValue();
        return new RegistroModel(correoElectronicoRegistroModel, contrasenaRegistroModel, nombreDeUsuarioRegistroModel);
    }

    public MutableLiveData<String> getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo) {
        correo_electronico.setValue(correo);
    }

    public MutableLiveData<String> getContrsena() {
        return contrsena;
    }

    public void setContrsena(String contrsena) {
        this.contrsena.setValue(contrsena);
    }

    public MutableLiveData<String> getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre) {
        nombre_de_usuario.setValue(nombre);
    }
}
