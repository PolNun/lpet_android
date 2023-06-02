package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentRegistroBinding;
import com.lpet.lpet_app.viewmodels.RegistroViewModel;

import java.util.Objects;

public class RegistroFragment extends Fragment {
    String correo_electronico;
    String contrasena;
    private FragmentRegistroBinding binding;
    RegistroViewModel registroViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registroViewModel = new ViewModelProvider(requireActivity()).get(RegistroViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        inicializar();

        return view;
    }

    private void inicializar() {
        binding.tvYaTengoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        });

        binding.btnContinuarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irANombreUsuarioFragment();
            }
        });
    }

    private void irANombreUsuarioFragment() {
        correo_electronico = binding.etCorreoElectronicoRegistro.getText().toString();
        contrasena = binding.etContrasenaRegistro.getText().toString();
        NombreUsuarioFragment nombreUsuarioFragment = new NombreUsuarioFragment();
        registroViewModel.setCorreo_electronico(correo_electronico);
        registroViewModel.setContrsena(contrasena);

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, nombreUsuarioFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}