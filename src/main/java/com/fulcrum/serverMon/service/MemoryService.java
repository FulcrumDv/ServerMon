package com.fulcrum.serverMon.service;

import com.fulcrum.serverMon.model.MemoryMetricsModel;
import com.fulcrum.serverMon.repository.MemoryMetricsRepo;
import com.fulcrum.serverMon.util.MetricsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MemoryService {
    private MemoryMetricsRepo MemoryStatistics;
    private MetricsCollector MemoryCollector;

    @Autowired
    public MemoryService(MemoryMetricsRepo MemoryStatsitics, MetricsCollector MemoryCollector){
        this.MemoryStatistics = MemoryStatsitics;
        this.MemoryCollector = MemoryCollector;
    }

    @Scheduled(fixedRate = 4000)
    public void collectAndSaveRam(){
        MemoryMetricsModel mem = MetricsCollector.collectedRamMetrics();
        MemoryStatistics.save(mem);
    }

}
