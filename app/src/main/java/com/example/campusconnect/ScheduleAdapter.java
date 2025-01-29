// ScheduleAdapter.java
package com.example.campusconnect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private List<ScheduleItem> scheduleList;

    // Constructor to pass the data to adapter
    public ScheduleAdapter(List<ScheduleItem> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_schedule_card, parent, false);
        return new ScheduleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleItem item = scheduleList.get(position);
        holder.classTime.setText(item.getClassTime());
        holder.unitName.setText(item.getUnitName());
        holder.lecturerName.setText(item.getLecturerName());
        holder.venue.setText(item.getVenue());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    // ViewHolder for each schedule card
    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView classTime, unitName, lecturerName, venue;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            classTime = itemView.findViewById(R.id.classTime);
            unitName = itemView.findViewById(R.id.unitName);
            lecturerName = itemView.findViewById(R.id.lecturerName);
            venue = itemView.findViewById(R.id.venue);
        }
    }
}
