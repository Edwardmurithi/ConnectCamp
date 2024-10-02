// HomeItem.java
package com.example.campusconnect;

public class HomeItem {
    private int iconResId;
    private String title;
    private String description;

    public HomeItem(int iconResId, String title, String description) {
        this.iconResId = iconResId;
        this.title = title;
        this.description = description;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
