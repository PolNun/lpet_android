package com.lpet.lpet_app.ui.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentNombreUsuarioBinding;

public class NombreUsuarioFragment extends Fragment {
    private String correo_electronico;
    private String contrasena;

    FragmentNombreUsuarioBinding binding;

    public NombreUsuarioFragment() {
    }

    public static NombreUsuarioFragment newInstance(String correo_electronico, String contrasena) {
        NombreUsuarioFragment fragment = new NombreUsuarioFragment();
        Bundle args = new Bundle();
        args.putString("correo_electronico", correo_electronico);
        args.putString("contrasena", contrasena);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        correo_electronico = getArguments().getString("correo_electronico");
        contrasena = getArguments().getString("contrasena");
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
                Toast.makeText(getContext(), correo_electronico, Toast.LENGTH_SHORT).show();
            }
        });
    }
}