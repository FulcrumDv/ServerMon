package com.fulcrum.serverMon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class MemoryMetricsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate timestamp;
    private long RamUsuage;
    private long RamAvailbale;
    private long RamTotal;


    public MemoryMetricsModel(){}

    public MemoryMetricsModel(LocalDate timestamp, long RamUsuage, long RamAvailable, long RamTotal){
        this.timestamp = timestamp;
        this.RamUsuage = RamUsuage;
        this.RamAvailbale = RamAvailable;
        this.RamTotal = RamTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public long getRamUsuage() {
        return RamUsuage;
    }

    public void setRamUsuage(long ramUsuage) {
        RamUsuage = ramUsuage;
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

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return "MemoryMetrics{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", RamUsuage" + RamUsuage +
                ", RamAvailable" + RamAvailbale +
                ", RamTotal" + RamTotal +
                '}';
}
}
