package com.lpet.lpet_app.views.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.utils.FieldValidator;
import com.lpet.lpet_app.viewmodels.login.LoginViewModel;

public class LoginFragment extends Fragment {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvGoToRegistration;
    private TextView tvForgotPassword;
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initializeView();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        loginViewModel.isLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading) {
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), loginResult -> {
            if (loginResult.equals("Login successful")) {
                goToHomeFragment(view);
            } else {
                Toast.makeText(getContext(), loginResult, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeView() {
        etEmail = binding.etLoginEmail;
        etPassword = binding.etLoginPassword;
        btnLogin = binding.btnLogin;
        tvGoToRegistration = binding.tvGoToRegistration;
        tvForgotPassword = binding.tvForgotPassword;
        progressBar = binding.progressBar;

        setTvGoToRegistration();
        setTvForgotPassword();
        setBtnLogin();
    }

    private void setTvGoToRegistration() {
        tvGoToRegistration.setOnClickListener(this::goToRegistrationFragment);
    }

    private void setTvForgotPassword() {
        tvForgotPassword.setOnClickListener(v -> Toast.makeText(getContext(), "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show());
    }

    private void setBtnLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                validateAndLogin(email, password);
            }
        });
    }

    private void validateAndLogin(String email, String password) {
        if (!FieldValidator.isValidEmail(email)) {
            etEmail.setError("Email inválido");
            return;
        }

        if (!FieldValidator.isValidPassword(password)) {
            etPassword.setError("Contraseña inválida");
            return;
        }

        loginViewModel.login(email, password);
    }

    private void goToHomeFragment(View v) {
        NavDirections actionGoToChats = LoginFragmentDirections.actionLoginFragmentToChatsActivity();
        Navigation.findNavController(v).navigate(actionGoToChats);
        requireActivity().finish();
    }

    private void goToRegistrationFragment(View v) {
        NavDirections actionGoToRegistration = LoginFragmentDirections.actionLoginFragmentToRegistroFragment2();
        Navigation.findNavController(v).navigate(actionGoToRegistration);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}