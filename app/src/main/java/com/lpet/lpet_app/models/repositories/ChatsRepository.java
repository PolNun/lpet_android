package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.models.chat.Chat;
import com.lpet.lpet_app.models.chat.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatsRepository {
    public List<Chat> getFakeChatData() {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat(1, "Cuti Romero", "Hola!", "12:00"));

        return chats;
    }
}
