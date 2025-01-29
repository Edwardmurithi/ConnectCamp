// ScheduleItem.java
package com.example.campusconnect;

public class ScheduleItem {

    private String classTime;
    private String unitName;
    private String lecturerName;
    private String venue;

    // Constructor
    public ScheduleItem(String classTime, String unitName, String lecturerName, String venue) {
        this.classTime = classTime;
        this.unitName = unitName;
        this.lecturerName = lecturerName;
        this.venue = venue;
    }

    // Getter methods
    public String getClassTime() {
        return classTime;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public String getVenue() {
        return venue;
    }
}
