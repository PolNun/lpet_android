package com.lpet.lpet_app.views.content.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.databinding.ActivityChatDetailBinding;
import com.lpet.lpet_app.models.chat.Message;
import com.lpet.lpet_app.models.repositories.ChatsRepository;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {
    private ActivityChatDetailBinding binding;
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String chatId = getIntent().getStringExtra("chat_id");
        String chatName = "Cuti Romero";

        recyclerView = binding.recyclerViewChatMessages;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessageAdapter();
        recyclerView.setAdapter(messageAdapter);

        // Crear los mensajes del chat
        List<Message> chatMessages = generateChatMessages();

        // Poner el nombre del chat en el TextView
        binding.textChatName.setText(chatName);

        // Poner los mensajes en el RecyclerView
        messageAdapter.setMessages(chatMessages);
    }

    private List<Message> generateChatMessages() {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Pablo", "Hola!", "1:00 PM"));
        messages.add(new Message("Cuti Romero", "Hola, loco!", "1:05 PM"));
        messages.add(new Message("Pablo", "Como estas?", "1:10 PM"));
        messages.add(new Message("Cuti Romero", "Bien, vos?", "1:15 PM"));
        messages.add(new Message("Pablo", "Bien, bien", "1:20 PM"));
        messages.add(new Message("Pablo", "Que haces?", "1:25 PM"));

        return messages;
    }
}
