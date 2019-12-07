package com.example.smartsale.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartsale.Models.MessageModel;
import com.example.smartsale.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>  {

    private List<MessageModel> messages;
    private Context context;

    public MessagesAdapter(List<MessageModel> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_messages, parent, false));
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {

        holder.sender.setText(messages.get(position).getSendername());
        holder.time.setText(messages.get(position).getTime());
        holder.messageContent.setText(messages.get(position).getMessage());


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static  class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView sender, time, messageContent;
        private Button more;

        public MessageViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.message_time);
            sender = itemView.findViewById(R.id.message_sender);
            messageContent = itemView.findViewById(R.id.message_content);
            more = itemView.findViewById(R.id.more_btn);

        }
    }
}
