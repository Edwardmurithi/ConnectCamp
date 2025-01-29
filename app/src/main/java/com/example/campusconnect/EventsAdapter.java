package com.example.campusconnect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<EventItem> eventsList;

    public EventsAdapter(List<EventItem> eventsList) {
        this.eventsList = eventsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_event_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventItem event = eventsList.get(position);
        holder.eventName.setText(event.getName());
        holder.eventDateTime.setText(event.getDateTime());
        holder.eventVenue.setText(event.getVenue());
        holder.eventDescription.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventDateTime, eventVenue, eventDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventDateTime = itemView.findViewById(R.id.eventDateTime);
            eventVenue = itemView.findViewById(R.id.eventVenue);
            eventDescription = itemView.findViewById(R.id.eventDescription);
        }
    }
}
