package com.lpet.lpet_app.viewmodels;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private String correo_electronico;
    private String contrasena;

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getCorreo_electronico() {
        return "hodsal";
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String login() {
        return "Correo electrónico: " + correo_electronico + "\nContraseña: " + contrasena;
    }
}
