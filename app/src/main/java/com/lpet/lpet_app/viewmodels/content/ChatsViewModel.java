package com.lpet.lpet_app.viewmodels.content;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.chat.Chat;

import java.util.List;

public class ChatsViewModel extends ViewModel {

    // Use a more descriptive variable name for clarity
    private final MutableLiveData<List<Chat>> chatListLiveData = new MutableLiveData<>();

    // Expose the LiveData as a read-only LiveData to the outside
    public LiveData<List<Chat>> getChatList() {
        return chatListLiveData;
    }

    // This method sets the value of the LiveData
    public void setChatList(List<Chat> chats) {
        chatListLiveData.setValue(chats);
    }
}
