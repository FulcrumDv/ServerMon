package com.fulcrum.serverMon.service;

import com.fulcrum.serverMon.model.CpuMetricsModel;
import com.fulcrum.serverMon.repository.CpuMetricsRepo;
import com.fulcrum.serverMon.util.MetricsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CpuService {

    private static CpuMetricsRepo cpuMetricsRepo;
    private static MetricsCollector metricsCollector;

    @Autowired
    public CpuService(CpuMetricsRepo cpuMetricsRepo, MetricsCollector metricsCollector) {
        CpuService.cpuMetricsRepo = cpuMetricsRepo;
        CpuService.metricsCollector = metricsCollector;
    }

    @Scheduled(fixedRate = 60000)
    public static void collectAndSaveCpuMetrics() {
        CpuMetricsModel metrics = MetricsCollector.collectedCpuMetrics();
        cpuMetricsRepo.save(metrics);
    }
}

