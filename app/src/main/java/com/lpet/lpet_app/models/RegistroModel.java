package com.lpet.lpet_app.models;

import androidx.annotation.NonNull;

public final class RegistroModel {
    private String correo_electronico;
    private String contrasena;
    private String nombre_de_usuario;

    public RegistroModel() {
    }

    public RegistroModel(String correo_electronico, String contrasena, String nombre_de_usuario) {
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.nombre_de_usuario = nombre_de_usuario;
    }

    @NonNull
    @Override
    public String toString() {
        return "Correo electrónico: " + correo_electronico
                + "\nContraseña: " + contrasena
                + "\nNombre de usuario: " + nombre_de_usuario + "\n";
    }
}
