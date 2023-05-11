package com.lpet.lpet_app.utils;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.ui.login.LoginFragment;
import com.lpet.lpet_app.ui.registro.RegistroFragment;

public class CargadorDeFragments {

    public static void cargarFragment(Context context, Fragment fragment, View view) {
        FragmentTransaction transaccion = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();

        if (fragment instanceof RegistroFragment || fragment instanceof LoginFragment) {
            transaccion.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        } else {
            transaccion.setCustomAnimations(R.anim.entrar_por_derecha, R.anim.salir_por_izquierda,
                            R.anim.entrar_por_izquierda, R.anim.salir_por_derecha)
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, fragment)
                    .commit();

        }
    }
}
