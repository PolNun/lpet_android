package com.lpet.lpet_app.models;

public class RegistroModel {
    private String correoElectronico;
    private String contrasena;
    private String nombreUsuario;

    public RegistroModel() {

    }

    public RegistroModel(String correoElectronico, String contrasena, String nombreUsuario) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "RegistroModel{" +
                "correoElectronico='" + correoElectronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
