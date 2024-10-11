package com.fulcrum.serverMon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CpuMetricsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // timestap for Historical data
    private LocalDateTime timestamp;
    private String cpuName;
    private int coreCount;

    private double loadPercentage;
    private double temp;

    public CpuMetricsModel() {
    }

    public CpuMetricsModel(LocalDateTime timestamp, String cpuName, int coreCount, double loadPercentage, double temp) {
        this.timestamp = timestamp;
        this.cpuName = cpuName;
        this.coreCount = coreCount;
        this.loadPercentage = loadPercentage;
        this.temp = temp;

    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public double getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(double loadPercentage) {
        this.loadPercentage = loadPercentage;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CpuMetrics{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", CpuName=" + cpuName +
                ", loadPercentage=" + loadPercentage +
                ", temp=" + temp +
                ", coreCount=" + coreCount +
                '}';
    }

}

