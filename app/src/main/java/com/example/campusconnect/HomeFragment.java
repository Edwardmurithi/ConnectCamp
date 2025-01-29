// HomeFragment.java
package com.example.campusconnect;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<HomeItem> itemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 columns for grid

        itemList = new ArrayList<>();
        // Add items to the list
        itemList.add(new HomeItem(R.drawable.baseline_schedule, "Schedule", "Check your class schedule."));
        itemList.add(new HomeItem(R.drawable.baseline_event, "Events", "Upcoming campus events."));
        itemList.add(new HomeItem(R.drawable.baseline_newspaper_24, "News", "Latest campus news."));
        itemList.add(new HomeItem(R.drawable.baseline_feedback_24, "Feedback", "Send us your feedback."));

        adapter = new HomeAdapter(itemList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
