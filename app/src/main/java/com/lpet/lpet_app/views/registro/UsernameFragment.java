package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentUsernameBinding;
import com.lpet.lpet_app.utils.FieldValidator;
import com.lpet.lpet_app.viewmodels.registro.RegistrationViewModel;

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
}
