package com.lpet.lpet_app.ui.login;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.viewmodels.LoginViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        inicializar();

        return view;
    }

    private void inicializar() {
        binding.tvIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections accionIrARegistro = LoginFragmentDirections.actionLoginFragmentToRegistroFragment2();
                Navigation.findNavController(v).navigate(accionIrARegistro);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}