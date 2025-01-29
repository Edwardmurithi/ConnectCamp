package com.example.campusconnect;

public class EventItem {
    private String name;
    private String dateTime;
    private String venue;
    private String description;

    public EventItem(String name, String dateTime, String venue, String description) {
        this.name = name;
        this.dateTime = dateTime;
        this.venue = venue;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDateTime() { return dateTime; }
    public String getVenue() { return venue; }
    public String getDescription() { return description; }
}
