package com.lpet.lpet_app.views.registro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.FragmentRegistroBinding;
import com.lpet.lpet_app.viewmodels.RegistroViewModel;

import java.util.Objects;

public class RegistroFragment extends Fragment {
    // ESTE ATRIBUTO ES PARA RELACIONAR LOS OBJETOS LOGICOS CON SUS RESPECTIVAS VIEWS MAS RAPIDO
    private FragmentRegistroBinding binding;
    // ESTE ATRIBUTO ES PARA PODER ENLAZAR EL VIEWMODEL CORRESPONDIENTE,ASU FRAGMENT CORRESPONDIENTE
    private RegistroViewModel registroViewModel;
    private String correo_electronico;
    private String contrasena;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ATRAVEZ DEL ATRIBUTO INSTANCIADO ANTERIORMENTE VOY A BUSCAR LA CLASE REGISTROVIEWMODEL Y LO GUARDO
        registroViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        inicializar();
        return view;
    }

    private void inicializar() {
        binding.tvYaTengoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        });
        // AL REALIZARSE CLICK EN EL DICHO BOTON SE REALIZARAN LAS ACCIONES DEMTRO DEL METODO
        binding.btnContinuarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo_electronico = binding.etCorreoElectronicoRegistro.getText().toString();
                contrasena = binding.etContrasenaRegistro.getText().toString();
                NombreUsuarioFragment nombreUsuarioFragment = new NombreUsuarioFragment();
                Bundle bundle = new Bundle();
                bundle.putString("correo_electronico", correo_electronico);
                bundle.putString("contrasena", contrasena);
                nombreUsuarioFragment.setArguments(bundle);

                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, nombreUsuarioFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(null)
                        .commit();
                guardarUsuarioRegistroFragment();
            }
        });
        // AL REALIZARSE CLICK EN EL DICHO BOTON SE REALIZARAN LAS ACCIONES DEMTRO DEL METODO
        binding.btnRegistrarseFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Registro con Facebook aún no implementado", Toast.LENGTH_SHORT).show();
            }
        });
        // AL REALIZARSE CLICK EN EL DICHO BOTON SE REALIZARAN LAS ACCIONES DEMTRO DEL METODO
        binding.btnRegistrarseGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Registro con Google aún no implementado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //OBTENGO EL ATRIBUTO CORREO ELECTRONICO PARA OBSERVAR SUS CAMBIOS Y ACTUALIZAR EL FRAGMENT SI ES NECESARIO
        registroViewModel.getCorreoElectronicoLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // manejar los cambios del email acá
            }
        });
        //OBTENGO EL ATRIBUTO CONTRASENA PARA OBSERVAR SUS CAMBIOS Y ACTUALIZAR EL FRAGMENT SI ES NECESARIO
        registroViewModel.getContrasenaLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // manejar los cambios de la contraseña acá
            }
        });
    }

    private void guardarUsuarioRegistroFragment() {
        //OBTENGO Y GUARDO LOS DATOS INGRESADOS POR EL USUARIO
        String correoElectronico = binding.etCorreoElectronicoRegistro.getText().toString();
        String contrasena = binding.etContrasenaRegistro.getText().toString();
        // LOS DATOS ANTERIORES LOS GUARDO EN EL REGISTROVIEWMODEL
        registroViewModel.setCorreoElectronico(correoElectronico);
        registroViewModel.setContrasena(contrasena);
        if (registroViewModel.validarCredencialesRegistroViewModel()) {
            Toast.makeText(getContext(), "Usuario ya registrado, intente con otro Email", Toast.LENGTH_SHORT).show();
        } else {
            RegistroViewModel.guardarUsuarioRegistroViewModel();
            Toast.makeText(getContext(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}