package com.lpet.lpet_app.views.content.chats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.api.WebSocketClient;
import com.lpet.lpet_app.databinding.ActivityChatDetailBinding;
import com.lpet.lpet_app.models.chat.Message;
import com.lpet.lpet_app.models.repositories.ChatsRepository;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class ChatDetailActivity extends AppCompatActivity {
    private ActivityChatDetailBinding binding;
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private WebSocket webSocket;
    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        System.out.println("onCreate");

        binding.buttonSend.setOnClickListener(v -> {
            String message = binding.editTextMessage.getText().toString();
            if (!message.isEmpty()) {
                webSocket.send(message);
                binding.editTextMessage.setText("");
            }
        });

        recyclerView = binding.recyclerViewChatMessages;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessageAdapter();
        recyclerView.setAdapter(messageAdapter);

        webSocketClient = WebSocketClient.getInstance();

        connectWebSocket("ws://10.0.2.2:8081/chat");
    }

    private void connectWebSocket(String wsUrl) {
        Request request = new Request.Builder()
                .url(wsUrl)
                .build();

        WebSocketListener webSocketListener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                System.out.println("onOpen");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                // Recibir mensaje
                // Actualizar vista
                System.out.println("onMessage");
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                super.onClosing(webSocket, code, reason);
                System.out.println("onClosing");
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
                super.onClosed(webSocket, code, reason);
                System.out.println("onClosed");
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
                if (response != null) {
                    Log.e("TAG", "WebSocket onFailure: " + response.code() + " " + response.message());
                    Log.e("TAG", "WebSocket onFailure: " + response.body());
                }
                Log.e("TAG", "WebSocket onFailure: " + t.getMessage());
                System.out.println("onFailure");
            }
        };

        webSocketClient.connectWebSocket(webSocketListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webSocketClient.disconnectWebSocket();
    }
}
