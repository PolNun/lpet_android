package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentUsernameBinding;
import com.lpet.lpet_app.utils.FieldValidator;
import com.lpet.lpet_app.viewmodels.registro.RegistrationViewModel;

import java.util.Objects;

public class UsernameFragment extends Fragment {
    private EditText etUsername;
    private Button btnRegister;
    private FragmentUsernameBinding binding;
    private RegistrationViewModel registrationViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUsernameBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initializeView();

        return view;
    }

    private void initializeView() {
        etUsername = binding.etUsername;
        btnRegister = binding.btnRegister;

        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();

                if (!validateAndSaveStep2Data(username)) {
                    return;
                }

                registerUser();
            }
        });
    }

    public Boolean validateAndSaveStep2Data(String username) {
        if (!FieldValidator.isValidUsername(username)) {
            etUsername.setError("El nombre de usuario es inválido");
            return false;
        }

        registrationViewModel.saveStep2Data(username);
        return true;
    }

    private void registerUser() {
        registrationViewModel.getRegistrationResult().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String result) {
                Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show();
            }
        });

        registrationViewModel.register();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);

        registrationViewModel.isLoading().observe(getViewLifecycleOwner(), isLoading -> {
            if (isLoading) {
                binding.progressBar.setIndeterminate(true);
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.INVISIBLE);
            }
        });

        registrationViewModel.getRegistrationResult().observe(getViewLifecycleOwner(), registrationResult -> {
            if (registrationResult.equals("Registration successful")) {
                goToHomeFragment(view);
            } else {
                Toast.makeText(getContext(), registrationResult, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goToHomeFragment(View view) {
        NavDirections actionGoToChats = UsernameFragmentDirections.actionNombreUsuarioFragmentToChatsActivity();
        Navigation.findNavController(view).navigate(actionGoToChats);
    }
}
