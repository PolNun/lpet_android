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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.viewmodels.login.LoginViewModel;

import java.util.Objects;

public class LoginFragment extends Fragment {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvGoToRegistration;
    private TextView tvForgotPassword;
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

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

        // Observe the isLoading and loginResult LiveData objects
        loginViewModel.isLoading().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                ProgressBar progressBar = new ProgressBar(getContext());
                if (isLoading) {
                    progressBar.setIndeterminate(true);
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String loginResult) {
                Toast.makeText(getContext(), loginResult, Toast.LENGTH_SHORT).show();
                if (loginResult.equals("Login successful")) {
                    goToHomeFragment(view);
                }
            }
        });
    }

    private void initializeView() {
        etEmail = binding.etLoginEmail;
        etPassword = binding.etLoginPassword;
        btnLogin = binding.btnLogin;
        tvGoToRegistration = binding.tvGoToRegistration;
        tvForgotPassword = binding.tvForgotPassword;

        setTvGoToRegistration();
        setTvForgotPassword();
        setBtnLogin();
    }

    private void setTvGoToRegistration() {
        tvGoToRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegistrationFragment(v);
            }
        });
    }

    private void setTvForgotPassword() {
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setBtnLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                loginViewModel.login(email, password);
            }
        });
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