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
        if (registroModel == null) {
            registroModel = new MutableLiveData<>();
        }
        return registroModel.getValue();
    }

    public void setRegistroModel(RegistroModel registroModel) {
        this.registroModel.setValue(registroModel);
    }

    public MutableLiveData<String> getCorreo_electronico() {
        if (correo_electronico == null) {
            correo_electronico = new MutableLiveData<>();
        }
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico.setValue(correo_electronico);
    }

    public MutableLiveData<String> getContrsena() {
        if (contrsena == null) {
            contrsena = new MutableLiveData<>();
        }
        return contrsena;
    }

    public void setContrsena(String contrsena) {
        this.contrsena.setValue(contrsena);
    }

    public MutableLiveData<String> getNombre_de_usuario() {
        if (nombre_de_usuario == null) {
            nombre_de_usuario = new MutableLiveData<>();
        }
        return nombre_de_usuario;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario.setValue(nombre_de_usuario);
    }
}
