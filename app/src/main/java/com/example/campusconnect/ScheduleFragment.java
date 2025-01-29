// ScheduleFragment.java
package com.example.campusconnect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;
    private List<ScheduleItem> scheduleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerSchedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the schedule list
        scheduleList = new ArrayList<>();

        // Adding some sample schedule items (You can replace with actual data)
        scheduleList.add(new ScheduleItem("9:00 AM", "Computer Science", "Dr. John", "Room 101"));
        scheduleList.add(new ScheduleItem("11:00 AM", "Mathematics", "Prof. Mary", "Room 102"));
        scheduleList.add(new ScheduleItem("1:00 PM", "Physics", "Dr. Smith", "Room 103"));
        scheduleList.add(new ScheduleItem("3:00 PM", "Chemistry", "Prof. Lewis", "Room 104"));

        // Initialize and set the adapter
        adapter = new ScheduleAdapter(scheduleList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
