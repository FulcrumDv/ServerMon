package com.fulcrum.serverMon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class MemoryMetricsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime timestamp;
    private double RamUsage;
    private long RamAvailbale;
    private long RamTotal;


    public MemoryMetricsModel(){}

    public MemoryMetricsModel(LocalDateTime timestamp, double RamUsage, long RamAvailable, long RamTotal){
        this.timestamp = timestamp;
        this.RamUsage = RamUsage;
        this.RamAvailbale = RamAvailable;
        this.RamTotal = RamTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getRamUsage() {
        return RamUsage;
    }

    public void setRamUsage(long ramUsage) {
        RamUsage = ramUsage;
    }

    public long getRamAvailbale() {
        return RamAvailbale;
    }

    public void setRamAvailbale(long ramAvailbale) {
        RamAvailbale = ramAvailbale;
    }

    public long getRamTotal() {
        return RamTotal;
    }

    public void setRamTotal(long ramTotal) {
        RamTotal = ramTotal;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "MemoryMetrics{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", RamUsage" + RamUsage +
                ", RamAvailable" + RamAvailbale +
                ", RamTotal" + RamTotal +
                '}';
}
}
