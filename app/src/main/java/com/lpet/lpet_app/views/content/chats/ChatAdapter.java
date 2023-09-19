package com.lpet.lpet_app.views.content.chats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.models.chat.Chat; // Import the Chat model

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private OnChatItemClickListener onChatItemClickListener;
    private List<Chat> chats;

    public interface OnChatItemClickListener {
        void onChatItemClick(Chat chat);
    }

    public void setOnChatItemClickListener(OnChatItemClickListener onChatItemClickListener) {
        this.onChatItemClickListener = onChatItemClickListener;
    }


    public void setChats(List<Chat> chats) {
        this.chats = chats;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.textChatName.setText(chat.getChatName());
        holder.textLastMessage.setText(chat.getLastMessage());
        holder.textTimestamp.setText(String.valueOf(chat.getTimestamp()));

        holder.itemView.setOnClickListener(v -> {
            if (onChatItemClickListener != null) {
                onChatItemClickListener.onChatItemClick(chat);
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textChatName;
        TextView textLastMessage;
        TextView textTimestamp;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textChatName = itemView.findViewById(R.id.textChatName);
            textLastMessage = itemView.findViewById(R.id.textLastMessage);
            textTimestamp = itemView.findViewById(R.id.textTimestamp);
        }
    }

    @Override
    public int getItemCount() {
        return chats != null ? chats.size() : 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false); // Use the chat item layout
        return new ViewHolder(view);
    }
}
