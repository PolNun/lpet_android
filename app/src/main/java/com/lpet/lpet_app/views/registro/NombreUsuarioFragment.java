package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentNombreUsuarioBinding;
import com.lpet.lpet_app.viewmodels.RegistroViewModel;

public class NombreUsuarioFragment extends Fragment {
    FragmentNombreUsuarioBinding binding;
    private String correo_electronico;
    private String contrasena;
    private RegistroViewModel registroViewModel;
    private String nombreUsuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        correo_electronico = getArguments().getString("correo_electronico");
        contrasena = getArguments().getString("contrasena");
        nombreUsuario = binding.tvTituloNombreUsuario.getText().toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNombreUsuarioBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        inicializar();

        return view;
    }

    private void inicializar() {
        binding.btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), correo_electronico + contrasena, Toast.LENGTH_SHORT).show();
            }
        });
    }
}