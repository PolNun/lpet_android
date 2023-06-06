package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lpet.lpet_app.databinding.FragmentUsernameBinding;
import com.lpet.lpet_app.viewmodels.RegistrationViewModel;

public class UsernameFragment extends Fragment {
    private EditText etUsername;
    private Button btnRegister;
    FragmentUsernameBinding binding;
    RegistrationViewModel registrationViewModel;

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
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();

                registrationViewModel.saveStep2Data(username);
                registrationViewModel.register();
                Toast.makeText(getContext(), "Usuario registrado" + registrationViewModel.getRegistrationModelLiveData().getValue().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registrationViewModel = new ViewModelProvider(requireActivity()).get(RegistrationViewModel.class);
    }
}