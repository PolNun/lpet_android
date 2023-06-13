package com.lpet.lpet_app.views.content.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.ActivityChatsBinding;

public class ChatsActivity extends AppCompatActivity {
    ActivityChatsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeView();
    }

    private void initializeView() {
        binding.mainContentToolbar.setTitle("Chats");
    }
}