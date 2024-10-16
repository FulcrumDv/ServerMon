package com.fulcrum.serverMon.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DiskMetricsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // timestap for Historical data
    private LocalDateTime timestamp;
    private String name;
    private long totalSpace;
    private long usedSpace;

    public DiskMetricsModel() {
    }

    public DiskMetricsModel(LocalDateTime timestamp, String diskName, long totalSpace, long usedSpace) {
        this.timestamp = timestamp;
        this.name = diskName;
        this.totalSpace = totalSpace;
        this.usedSpace = usedSpace;
    }
    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(long usedSpace) {
        this.usedSpace = usedSpace;
    }
}
