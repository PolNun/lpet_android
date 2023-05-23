package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentNombreUsuarioBinding;

public class NombreUsuarioFragment extends Fragment {
    private String correo_electronico;
    private String contrasena;
    private String nombre_usuario;
    FragmentNombreUsuarioBinding binding;

    public NombreUsuarioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        correo_electronico = getArguments().getString("correo_electronico");
        contrasena = getArguments().getString("contrasena");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNombreUsuarioBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        inicializar();

        return view;
    }

    private void inicializar() {
        binding.btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre_usuario = binding.etNombreDeUsuario.getText().toString();
                Toast.makeText(getContext(), correo_electronico + contrasena + nombre_usuario, Toast.LENGTH_SHORT).show();
            }
        });
    }
}