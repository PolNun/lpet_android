package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentNombreUsuarioBinding;
import com.lpet.lpet_app.models.RegistroModel;
import com.lpet.lpet_app.viewmodels.RegistroViewModel;

public class NombreUsuarioFragment extends Fragment {
    private String correo_electronico;
    private String contrasena;
    private String nombre_usuario;
    FragmentNombreUsuarioBinding binding;
    RegistroViewModel registroViewModel;

    public NombreUsuarioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registroViewModel = new ViewModelProvider(requireActivity()).get(RegistroViewModel.class);
        correo_electronico = registroViewModel.getCorreo_electronico().getValue();
        contrasena = registroViewModel.getContrsena().getValue();
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
                registroViewModel.setNombre_de_usuario(nombre_usuario);
                RegistroModel registroModel = new RegistroModel(nombre_usuario, correo_electronico, contrasena);
                registroViewModel.setRegistroModel(registroModel);
                Toast.makeText(getContext(), registroViewModel.getRegistroModel().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}