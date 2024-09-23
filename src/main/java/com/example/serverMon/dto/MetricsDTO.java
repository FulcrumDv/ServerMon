package com.example.serverMon.dto;

public class MetricsDTO {
    private String title;
    private String value;
    private boolean upward;
    private String percent;

    // Constructor
    public MetricsDTO(String title, String value, boolean upward, String percent) {
        this.title = title;
        this.value = value;
        this.upward = upward;
        this.percent = percent;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public boolean isUpward() { return upward; }
    public void setUpward(boolean upward) { this.upward = upward; }
    public String getPercent() { return percent; }
    public void setPercent(String percent) { this.percent = percent; }
}