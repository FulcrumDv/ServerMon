package com.fulcrum.serverMon.service;

import com.fulcrum.serverMon.model.DiskMetricsModel;
import com.fulcrum.serverMon.repository.DiskMetricsRepo;
import com.fulcrum.serverMon.util.MetricsCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiskService {
    private static DiskMetricsRepo diskMetricsRepo;
    private static MetricsCollector metricsCollector;

    @Autowired
    public DiskService(DiskMetricsRepo diskMetricsRepo, MetricsCollector metricsCollector) {
        DiskService.diskMetricsRepo = diskMetricsRepo;
        DiskService.metricsCollector = metricsCollector;
    }

    @Scheduled(fixedRate = 60000)
    public static void collectAndSaveDiskMetrics() {
        List<DiskMetricsModel> metrics = metricsCollector.collectedDiskMetrics();
        diskMetricsRepo.saveAll(metrics);
    }
}
