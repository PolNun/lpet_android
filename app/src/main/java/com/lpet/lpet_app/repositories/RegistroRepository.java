package com.lpet.lpet_app.repositories;



import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.utils.BBDDUsuarios;
import com.lpet.lpet_app.viewmodels.RegistroViewModel;

import java.util.List;

public class RegistroRepository {

    private BBDDUsuarios bbddUsuarios;
    private RegistroViewModel registroViewModel;
    public RegistroRepository() {
        bbddUsuarios = new BBDDUsuarios();
    }


    public boolean guardarUsuarioRegistroRepository(String correo, String contrasena) {

        bbddUsuarios.setUsuarios(bbddUsuarios.getUsuarios(),RegistroViewModel.getCorreoElectronicoLiveData().getValue(), RegistroViewModel.getContrasenaLiveData().getValue(),);
        return true;
    }

    public boolean validarCredencialesRegistroRepository(String correo, String contrasena) {
         List<LoginModel> usuarios = bbddUsuarios.getUsuarios();

        for (LoginModel usuario : usuarios) {
            if (usuario.getCorreoElectronico().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }
}
