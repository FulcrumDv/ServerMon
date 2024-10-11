package com.fulcrum.serverMon.service;

import com.fulcrum.serverMon.model.CpuMetricsModel;
import com.fulcrum.serverMon.repository.CpuMetricsRepo;
import com.fulcrum.serverMon.util.MetricsCollector;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CpuService {

    private static CpuMetricsRepo cpuMetricsRepo;
    private MetricsCollector metricsCollector;

    public CpuService(CpuMetricsRepo cpuMetricsRepo, MetricsCollector metricsCollector) {
        CpuService.cpuMetricsRepo = cpuMetricsRepo;
        this.metricsCollector = metricsCollector;
    }

    @Scheduled(fixedRate = 60000)
    public static void collectAndSaveMetrics() {
        CpuMetricsModel metrics = com.fulcrum.serverMon.util.MetricsCollector.collectedCpuMetrics();
        cpuMetricsRepo.save(metrics);
    }
}
