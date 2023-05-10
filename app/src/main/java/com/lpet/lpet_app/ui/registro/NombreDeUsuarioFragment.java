package com.lpet.lpet_app.ui.registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentNombreDeUsuarioBinding;

public class NombreDeUsuarioFragment extends Fragment {
    private FragmentNombreDeUsuarioBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentNombreDeUsuarioBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nombre_de_usuario, container, false);
    }
}