package com.lpet.lpet_app.views.content.chats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lpet.lpet_app.R;
import com.lpet.lpet_app.models.chat.Message;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.textSender.setText(message.getSender());
        holder.textContent.setText(message.getContent());
        holder.textTimestamp.setText(message.getTimestamp());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textSender;
        TextView textContent;
        TextView textTimestamp;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textSender = itemView.findViewById(R.id.textSender);
            textContent = itemView.findViewById(R.id.textContent);
            textTimestamp = itemView.findViewById(R.id.textTimestamp);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if (message.getSender().equals("Pablo")) {
            return R.layout.item_message_sender;
        } else {
            return R.layout.item_message_receiver;
        }
    }

    @Override
    public int getItemCount() {
        return messages != null ? messages.size() : 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sender, parent, false);
        return new ViewHolder(view);
    }
}
