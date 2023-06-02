package com.lpet.lpet_app.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lpet.lpet_app.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.activity_main, null);
        int orientation = getResources().getInteger(R.integer.orientation_portrait);
        setRequestedOrientation(orientation);
        setContentView(view);
    }
}