package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lpet.lpet_app.databinding.FragmentRegistrationBinding;
import com.lpet.lpet_app.viewmodels.RegistrationViewModel;

public class RegistrationFragment extends Fragment {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnNext;
    FragmentRegistrationBinding binding;
    RegistrationViewModel registrationViewModel;

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
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                registrationViewModel.saveStep1Data(email, password);
                NavDirections action = RegistrationFragmentDirections.actionRegistroFragmentToNombreUsuarioFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);
    }
}