package com.lpet.lpet_app.repositories;
import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.utils.BBDDUsuarios;

import java.util.List;

public class LoginRepository {

    private BBDDUsuarios bbddUsuarios;

        public LoginRepository() {
            bbddUsuarios = new BBDDUsuarios();
        }


        public boolean validarCredencialesLoginRepository(String correo, String contrasena) {
        List<LoginModel> usuarios = bbddUsuarios.getUsuarios();

        for (LoginModel usuario : usuarios) {
            if (usuario.getCorreoElectronico().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }

// TODO crear la logica de la clase LoginRepository
}
