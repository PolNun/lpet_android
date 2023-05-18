package com.lpet.lpet_app.utils;

import com.lpet.lpet_app.models.LoginModel;

import java.util.ArrayList;
import java.util.List;

public class BBDD_alternativa {

    List<LoginModel> listaUsuarios = new ArrayList<>();

    public void agregarUsuarios(){
        listaUsuarios.add(new LoginModel());
    }

}
