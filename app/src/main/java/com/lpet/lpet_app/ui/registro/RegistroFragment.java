package com.lpet.lpet_app.ui.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentRegistroBinding;

public class RegistroFragment extends Fragment {
    String correo_electronico;
    String contrasena;
    private FragmentRegistroBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        inicializar();

        return view;
    }

    private void inicializar() {
        binding.tvYaTengoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        binding.btnContinuarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo_electronico = binding.etCorreoElectronicoRegistro.getText().toString();
                contrasena = binding.etContrasenaRegistro.getText().toString();

                NombreUsuarioFragment nombreUsuarioFragment = new NombreUsuarioFragment();
                Bundle bundle = new Bundle();
                bundle.putString("correo_electronico", correo_electronico);
                bundle.putString("contrasena", contrasena);
                nombreUsuarioFragment.setArguments(bundle);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nombreUsuarioFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}