package com.lpet.lpet_app.views.content.chats;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.databinding.ActivityChatsBinding;
import com.lpet.lpet_app.models.chat.Message;
import com.lpet.lpet_app.models.repositories.ChatsRepository;
import com.lpet.lpet_app.viewmodels.content.ChatsViewModel;

import java.util.List;

public class ChatsActivity extends AppCompatActivity {

    private ActivityChatsBinding binding;
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ChatsViewModel chatsViewModel;
    private ChatsRepository chatsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializeViewModels();
        setupRecyclerView();

        observeChatMessages();
    }

    private void initializeViewModels() {
        chatsViewModel = new ViewModelProvider(this).get(ChatsViewModel.class);
        chatsRepository = new ChatsRepository();

        List<Message> fakeMessages = chatsRepository.getFakeChatData();
        chatsViewModel.setChatMessages(fakeMessages);
    }

    private void setupRecyclerView() {
        recyclerView = binding.chatsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter();
        recyclerView.setAdapter(chatAdapter);
    }

    private void observeChatMessages() {
        chatsViewModel.getChatMessages().observe(this, messages -> {
            chatAdapter.setMessages(messages);
        });
    }
}