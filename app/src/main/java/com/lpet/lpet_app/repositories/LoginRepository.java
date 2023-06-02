package com.lpet.lpet_app.repositories;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.utils.BBDDUsuarios;

import java.util.List;

public class LoginRepository {
    private final BBDDUsuarios bbddUsuarios;

    public LoginRepository() {
        bbddUsuarios = new BBDDUsuarios();
    }

    public boolean validarCredencialesLoginRepository(String correoElectronico, String contrasena) {
        List<LoginModel> usuarios = bbddUsuarios.getUsuarios();

        for (LoginModel usuario : usuarios) {
            if (usuario.getCorreoElectronico().equals(correoElectronico) && usuario.getContrasena().equals(contrasena)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }


}
