package com.lpet.lpet_app.models;

import java.util.Objects;

public final class LoginModel {
    private String correoElectronico;
    private String contrasena;


    public LoginModel(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "LoginModel[" +
                "correoElectronico=" + correoElectronico + ", " +
                "contrasena=" + contrasena + ']';
    }

// TODO Tomar estos atributos y utilizarlos en todas las demas clases del mvvm
    // TODO HACER LA CLASE REPOSITORIO QUE SE CONECTE AL VIEWMODELLOGIN Y AL SERVIDOR
}
