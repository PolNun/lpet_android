package com.lpet.lpet_app.ui.login;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.ui.MainActivity;
import com.lpet.lpet_app.ui.registro.RegistroFragment;

public class LoginFragment extends Fragment {
private FragmentLoginBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLoginBinding.inflate(getLayoutInflater());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView tvRegistrarte = view.findViewById(R.id.tvRegistrate);

        tvRegistrarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmenteRegistro(v);
            }
        });
        // Inflate the layout for this fragment
        return view;

    }

    private void cargarFragmenteRegistro(View v) {
        RegistroFragment registroFragment = new RegistroFragment();
        FragmentTransaction transaccion = getFragmentManager().beginTransaction();
        transaccion.replace(R.id.fragment_container,registroFragment);
        transaccion.addToBackStack(null);
        transaccion.commit();
    }
}