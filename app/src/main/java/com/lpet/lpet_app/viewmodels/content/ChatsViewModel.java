package com.lpet.lpet_app.viewmodels.content;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.chat.Message;

import java.util.List;

public class ChatsViewModel extends ViewModel {

    private final MutableLiveData<List<Message>> chatMessages = new MutableLiveData<>();

    public LiveData<List<Message>> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(List<Message> messages) {
        chatMessages.setValue(messages);
    }
}
