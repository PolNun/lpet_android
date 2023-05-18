package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentRegistroBinding;

import java.util.Objects;

public class RegistroFragment extends Fragment {
    String correo_electronico;
    String contrasena;
    private FragmentRegistroBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                correo_electronico = binding.etCorreoElectronicoRegistro.getText().toString();
                contrasena = binding.etContrasenaRegistro.getText().toString();

                /*
                TODO: remplazar este código para que se valide el correo electrónico y la contraseña y se utilice el viewmodel de registro
                TODO: se deben generar clases de validación para los campos
                 */

                NombreUsuarioFragment nombreUsuarioFragment = new NombreUsuarioFragment();
                Bundle bundle = new Bundle();
                bundle.putString("correo_electronico", correo_electronico);
                bundle.putString("contrasena", contrasena);
                nombreUsuarioFragment.setArguments(bundle);

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nombreUsuarioFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
            }
        });

        binding.btnRegistrarseFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Registro con Facebook aún no implementado", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegistrarseGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Registro con Google aún no implementado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}