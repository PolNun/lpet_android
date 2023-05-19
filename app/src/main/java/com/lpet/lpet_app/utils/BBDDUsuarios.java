package com.lpet.lpet_app.utils;

import com.lpet.lpet_app.models.LoginModel;

import java.util.ArrayList;
import java.util.List;

public class BBDDUsuarios {

    private List<LoginModel> usuarios;

    public BBDDUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new LoginModel("matias@hotmail.com", "1234"));
        usuarios.add(new LoginModel("eli@hotmail.com", "12345"));
        usuarios.add(new LoginModel("pablo@hotmail.com", "12346"));
        usuarios.add(new LoginModel("marito@hotmail.com", "12347"));
    }

    public List<LoginModel> getUsuarios() {
        return usuarios;
    }

    public LoginModel getUsuarioPorEmail(String email){
        for(LoginModel usuario: usuarios){
            if(usuario.getCorreoElectronico().equals(email)){
                return usuario;
            }
        }
    return null;
    }
}
