package com.lpet.lpet_app.models.repositories;

import com.lpet.lpet_app.models.chat.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatsRepository {
    public List<Message> getFakeChatData() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Pablo", "Hola", "12:00"));
        messages.add(new Message("Pablo", "¿Cómo estás?", "12:00"));
        messages.add(new Message("Lio Messi", "Estoy bien", "12:00"));
        messages.add(new Message("Lio Messi", "¿Y vos?", "12:00"));
        messages.add(new Message("Pablo", "Yo también estoy bien", "12:00"));
        messages.add(new Message("Pablo", "¿Qué estás haciendo?", "12:00"));
        messages.add(new Message("Lio Messi", "Estoy trabajando", "12:00"));
        messages.add(new Message("Lio Messi", "¿Y vos?", "12:00"));
        messages.add(new Message("Pablo", "Yo también estoy trabajando", "12:00"));

        return messages;
    }
}
