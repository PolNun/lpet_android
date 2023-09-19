package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lpet.lpet_app.databinding.FragmentRegistrationBinding;
import com.lpet.lpet_app.utils.FieldValidator;
import com.lpet.lpet_app.viewmodels.registro.RegistrationViewModel;

public class RegistrationFragment extends Fragment {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnNext;
    private EditText etRepeatPassword;
    private FragmentRegistrationBinding binding;
    private RegistrationViewModel registrationViewModel;
    private TextView tvAlreadyRegistered;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initializeView();
        return view;
    }

    private void initializeView() {
        etEmail = binding.etRegistrationEmail;
        etPassword = binding.etRegistrationPassword;
        btnNext = binding.btnContinueRegistration;
        etRepeatPassword = binding.etRepeatPassword;
        tvAlreadyRegistered = binding.tvAlreadyRegistered;

        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String repeatPassword = etRepeatPassword.getText().toString();

                if (!validateAndSaveStep1Data(email, password, repeatPassword)) {
                    return;
                }

                NavDirections action = RegistrationFragmentDirections.actionRegistroFragmentToNombreUsuarioFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });

        tvAlreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });
    }

    private Boolean validateAndSaveStep1Data(String email, String password, String repeatPassword) {
        if (!FieldValidator.isValidEmail(email)) {
            etEmail.setError("Email inválido");
            return false;
        }

        if (!FieldValidator.isValidPassword(password)) {
            etPassword.setError("Contraseña inválida");
            return false;
        }

        if (!FieldValidator.isValidRepeatPassword(password, repeatPassword)) {
            etRepeatPassword.setError("Las contraseñas no coinciden");
            return false;
        }

        registrationViewModel.saveStep1Data(email, password);

        return true;
    }
}
