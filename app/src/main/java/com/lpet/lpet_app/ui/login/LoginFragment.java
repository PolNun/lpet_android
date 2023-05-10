package com.lpet.lpet_app.ui.login;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.ui.registro.RegistroFragment;
import com.lpet.lpet_app.utils.CargadorDeFragments;

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
        TextView tvIrARegistro = view.findViewById(R.id.tvIrARegistro);

        tvIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargadorDeFragments.cargarFragment(getContext(), new RegistroFragment(), view);
            }
        });
        return view;

    }
}