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

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> messages;

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = viewType == 1 ? R.layout.item_message_receiver : R.layout.item_message_sender;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.textSender.setText(message.getSender());
        holder.textContent.setText(message.getContent());
        holder.textTimestamp.setText(message.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return messages != null ? messages.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        // Devuelve 0 para el mensaje del receptor y 1 para el mensaje del emisor
        return messages.get(position).getSender().equals("Pablo") ? 1 : 0;
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
}
