package com.lpet.lpet_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.ActivityMainBinding;
import com.lpet.lpet_app.ui.login.LoginFragment;
import com.lpet.lpet_app.ui.registro.RegistroFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        cargarLoginFragment(view);
    }

    public void cargarLoginFragment(View view) {
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, loginFragment).commit();
    }
}