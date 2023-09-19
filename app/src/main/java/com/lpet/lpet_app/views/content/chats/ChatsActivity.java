package com.lpet.lpet_app.views.content.chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.databinding.ActivityChatsBinding;
import com.lpet.lpet_app.models.chat.Chat;
import com.lpet.lpet_app.models.repositories.ChatsRepository;
import com.lpet.lpet_app.viewmodels.content.ChatsViewModel;

import java.util.List;

public class ChatsActivity extends AppCompatActivity implements ChatAdapter.OnChatItemClickListener {

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

        observeChatList();

        chatAdapter.setOnChatItemClickListener(this);
    }

    private void initializeViewModels() {
        chatsViewModel = new ViewModelProvider(this).get(ChatsViewModel.class);
        chatsRepository = new ChatsRepository();

        List<Chat> fakeChats = chatsRepository.getFakeChatData();
        chatsViewModel.setChatList(fakeChats);
    }

    private void setupRecyclerView() {
        recyclerView = binding.chatsRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        chatAdapter = new ChatAdapter();
        recyclerView.setAdapter(chatAdapter);
    }

    private void observeChatList() {
        chatsViewModel.getChatList().observe(this, chats -> {
            chatAdapter.setChats(chats);
        });
    }

    @Override
    public void onChatItemClick(Chat chat) {
        Intent i = new Intent(this, ChatDetailActivity.class);
        i.putExtra("chat_id", chat.getChatId());
        startActivity(i);
    }
}
