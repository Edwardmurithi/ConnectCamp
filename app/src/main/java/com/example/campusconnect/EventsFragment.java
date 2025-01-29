package com.example.campusconnect;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {
    private RecyclerView recyclerView;
    private EventsAdapter adapter;
    private TextView noEventsPlaceholder;
    private List<EventItem> eventList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = view.findViewById(R.id.recyclerEvents);
        noEventsPlaceholder = view.findViewById(R.id.noEventsPlaceholder);

        eventList = new ArrayList<>();
        eventList.add(new EventItem("Tech Summit", "March 12, 10:00 AM", "Auditorium", "A deep dive into the latest tech trends."));
        eventList.add(new EventItem("Cultural Fest", "March 15, 2:00 PM", "Main Hall", "Experience diverse cultures through music and dance."));
        eventList.add(new EventItem("Hackathon", "March 20, 9:00 AM", "IT Lab", "48-hour coding competition."));
        eventList.add(new EventItem("Entrepreneur Workshop", "March 25, 11:00 AM", "Conference Room", "Learn from top business leaders."));

        adapter = new EventsAdapter(eventList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        noEventsPlaceholder.setVisibility(eventList.isEmpty() ? View.VISIBLE : View.GONE);

        return view;
    }
}
