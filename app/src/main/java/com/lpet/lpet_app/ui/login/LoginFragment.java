package com.lpet.lpet_app.ui.login;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentLoginBinding;
import com.lpet.lpet_app.ui.registro.RegistroFragment;
import com.lpet.lpet_app.utils.CargadorDeFragments;
import com.lpet.lpet_app.viewmodels.LoginViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    private String correo_electronico;
    private String contrasena;
    private LoginViewModel loginViewModel;
    private Button btnLogin;
    EditText etCorreoElectronico;
    EditText etContrasena;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView tvIrARegistro = view.findViewById(R.id.tvIrARegistro);
        btnLogin = view.findViewById(R.id.btnLogin);
        etCorreoElectronico = view.findViewById(R.id.etCorreoElectronico);
        etContrasena = view.findViewById(R.id.etContrasena);
        etCorreoElectronico.setText(loginViewModel.getCorreo_electronico());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo_electronico = etCorreoElectronico.getText().toString();
                contrasena = etContrasena.getText().toString();
                loginViewModel.setCorreo_electronico(correo_electronico);
                loginViewModel.setContrasena(contrasena);
                String mensaje = loginViewModel.login();
                Toast.makeText(getContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });

        tvIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargadorDeFragments.cargarFragment(getContext(), new RegistroFragment(), view);
            }
        });
        return view;
    }
}