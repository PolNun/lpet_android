package com.lpet.lpet_app.views.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.models.LoginModel;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel.getCorreoElectronicoLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // manejar los cambios del email acá
            }
        });

        loginViewModel.getContrasenaLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // manejar los cambios de la contraseña acá
            }
        });
    }

    private void inicializar() {
        binding.tvIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections accionIrARegistro = LoginFragmentDirections.actionLoginFragmentToRegistroFragment2();
                Navigation.findNavController(v).navigate(accionIrARegistro);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCredencialesLoginFragment();
            }
        });
    }

    private void validarCredencialesLoginFragment() {
        String correoElectronico = binding.etCorreoElectronico.getText().toString();
        String contrasena= binding.etContrasenaLogin.getText().toString();

       loginViewModel.setCorreoElectronico(correoElectronico);
       loginViewModel.setContrasena(contrasena);
       if(loginViewModel.validarCredencialesLoginViewModel()){
           Toast.makeText(getContext(), "Usuario Logueado", Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}