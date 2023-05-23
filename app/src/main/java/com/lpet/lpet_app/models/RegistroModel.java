package com.lpet.lpet_app.models;

public class RegistroModel {
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


    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre_de_usuario() {
        return nombre_de_usuario;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre_de_usuario(String nombre_de_usuario) {
        this.nombre_de_usuario = nombre_de_usuario;
    }
}
