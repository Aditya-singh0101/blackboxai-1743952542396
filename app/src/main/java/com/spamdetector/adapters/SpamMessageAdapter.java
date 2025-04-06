package com.spamdetector.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.spamdetector.R;
import com.spamdetector.models.SpamMessage;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class SpamMessageAdapter extends RecyclerView.Adapter<SpamMessageAdapter.SpamMessageViewHolder> {

    private final List<SpamMessage> spamMessages;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault());

    public SpamMessageAdapter(List<SpamMessage> spamMessages) {
        this.spamMessages = spamMessages;
    }

    @NonNull
    @Override
    public SpamMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spam_message, parent, false);
        return new SpamMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpamMessageViewHolder holder, int position) {
        SpamMessage message = spamMessages.get(position);
        holder.senderTextView.setText(message.getSender());
        holder.contentTextView.setText(message.getContent());
        holder.timeTextView.setText(dateFormat.format(message.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return spamMessages.size();
    }

    static class SpamMessageViewHolder extends RecyclerView.ViewHolder {
        TextView senderTextView;
        TextView contentTextView;
        TextView timeTextView;

        public SpamMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            senderTextView = itemView.findViewById(R.id.senderTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }
}