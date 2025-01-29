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

public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.recyclerNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Setup adapter with sample data
        adapter = new NewsAdapter(getSampleNews());
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Sample data for news
    private List<Object> getSampleNews() {
        List<Object> newsList = new ArrayList<>();

        // Adding sections first
        newsList.add("Breaking News");
        newsList.add(new NewsItem("Breaking News", "This is the description of the breaking news."));
        newsList.add(new NewsItem("Breaking News 2", "Another breaking news item."));

        newsList.add("Tech News");
        newsList.add(new NewsItem("Tech News", "Latest technology updates available here."));
        newsList.add(new NewsItem("Tech News 2", "New phone release with amazing features."));

        newsList.add("Sports");
        newsList.add(new NewsItem("Sports", "Recent sports news you must know."));
        newsList.add(new NewsItem("Sports 2", "Local team wins the championship."));

        return newsList;
    }

}
