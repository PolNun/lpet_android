package com.lpet.lpet_app.ui.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpet.lpet_app.R;

public class NombreUsuarioFragment extends Fragment {
    private String correo_electronico;
    private String contrasena;

    public NombreUsuarioFragment() {
    }

    public NombreUsuarioFragment(String correo_electronico, String contrasena) {
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nombre_usuario, container, false);
    }
}