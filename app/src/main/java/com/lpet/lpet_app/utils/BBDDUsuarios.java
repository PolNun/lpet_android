package com.lpet.lpet_app.utils;

import static java.security.AccessController.getContext;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.models.RegistroModel;

import java.util.ArrayList;
import java.util.List;

public class BBDDUsuarios {

    private List<LoginModel> usuarios;
    private List<RegistroModel> usuariosRegistro;

    public BBDDUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new LoginModel("matias@hotmail.com", "1234"));
        usuarios.add(new LoginModel("eli@hotmail.com", "12345"));
        usuarios.add(new LoginModel("pablo@hotmail.com", "12346"));
        usuarios.add(new LoginModel("marito@hotmail.com", "12347"));

        usuariosRegistro = new ArrayList<>();
        usuariosRegistro.add(new RegistroModel("matias@hotmail.com", "1234", "matu"));
        usuariosRegistro.add(new  RegistroModel("eli@hotmail.com", "12345","elo857"));
        usuariosRegistro.add(new  RegistroModel("pablo@hotmail.com", "12346","elpablo789"));
        usuariosRegistro.add(new  RegistroModel("marito@hotmail.com", "12347","mariobros87"));

    }
    // METDO GET PARA OBTENER LA LISTA DE USUARIOS
    public List<LoginModel> getUsuarios() {
        return usuarios;
    }

    // METDO SET PARA ESTABLECER LOS DATOS DE LA LISTA DE USUARIOS Y MOSTRAR LA LISTA EN LOGCAT
    public  void setUsuarios(List<RegistroModel> usuariosRegistro,String correoElectronico, String contrasena, String nombreUsuario) {
        usuariosRegistro.add(new RegistroModel(correoElectronico,contrasena,nombreUsuario));

        for (RegistroModel u : usuariosRegistro){
            Log.d("TAG", u.toString());
        }
        }


    // ME PARECE QUE ESTE METODO HAY QUE ELIMINARLO ESATRIA DE MAS POR AHORA
    public LoginModel getUsuarioPorEmail(String email){
        for(LoginModel usuario: usuarios){
            if(usuario.getCorreoElectronico().equals(email)){
                return usuario;
            }
        }
    return null;
    }
}
