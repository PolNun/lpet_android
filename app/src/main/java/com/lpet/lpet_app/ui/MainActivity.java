package com.lpet.lpet_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.ActivityMainBinding;
import com.lpet.lpet_app.ui.login.LoginFragment;
import com.lpet.lpet_app.ui.registro.RegistroFragment;
import com.lpet.lpet_app.utils.CargadorDeFragments;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        CargadorDeFragments.cargarFragment(this, new LoginFragment(), view);
    }
}