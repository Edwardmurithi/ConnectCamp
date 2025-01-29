package com.example.campusconnect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SECTION = 0;
    private static final int TYPE_ITEM = 1;

    private List<Object> newsList;

    public NewsAdapter(List<Object> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int getItemViewType(int position) {
        // Check if the item is a section or news item
        if (newsList.get(position) instanceof String) {
            return TYPE_SECTION;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_SECTION) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_section, parent, false);
            return new SectionViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_article, parent, false);
            return new NewsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SectionViewHolder) {
            String sectionTitle = (String) newsList.get(position);
            ((SectionViewHolder) holder).titleTextView.setText(sectionTitle);
        } else if (holder instanceof NewsViewHolder) {
            NewsItem newsItem = (NewsItem) newsList.get(position);
            ((NewsViewHolder) holder).titleTextView.setText(newsItem.getTitle());
            ((NewsViewHolder) holder).descriptionTextView.setText(newsItem.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.newsTitle);
            descriptionTextView = itemView.findViewById(R.id.newsDescription);
        }
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public SectionViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.sectionTitle);
        }
    }
}
