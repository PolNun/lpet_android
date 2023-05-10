package com.lpet.lpet_app.ui.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.databinding.FragmentRegistroBinding;
import com.lpet.lpet_app.ui.login.LoginFragment;

public class RegistroFragment extends Fragment {
    private FragmentRegistroBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentRegistroBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro, container, false);
        Button btnRegistrarte = view.findViewById(R.id.btnRegistrarse);

        btnRegistrarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmentNombreUsuario(v);
            }
        });
        return view;
    }

    private void cargarFragmentNombreUsuario(View v) {
        NombreDeUsuarioFragment nombreDeUsuarioFragment = new NombreDeUsuarioFragment();
        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.fragment_container, nombreDeUsuarioFragment);
        transaccion.addToBackStack(null);
        transaccion.commit();
    }
}