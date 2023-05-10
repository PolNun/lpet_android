package com.lpet.lpet_app.utils;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.lpet.lpet_app.R;

public class CargadorDeFragments {

    public static void cargarFragment(Context context, Fragment fragment, View view) {
        FragmentTransaction transaccion = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
        transaccion.setCustomAnimations(R.anim.entrar_por_derecha, R.anim.salir_por_izquierda, R.anim.entrar_por_izquierda, R.anim.salir_por_derecha)
                .addToBackStack(null)
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
