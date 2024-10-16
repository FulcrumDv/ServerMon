package com.fulcrum.serverMon.controller;

import com.fulcrum.serverMon.model.DiskMetricsModel;
import com.fulcrum.serverMon.repository.DiskMetricsRepo;
import com.fulcrum.serverMon.service.DiskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/disk-metrics")
public class DiskController {
    private final DiskMetricsRepo diskMetricsRepository;
    private final DiskService diskService;

    // Constructor injection of dependencies
    public DiskController(DiskMetricsRepo diskMetricsRepository, DiskService diskService) {
        this.diskMetricsRepository = diskMetricsRepository;
        this.diskService = diskService;
    }

    @PostMapping("/collect") // collect and save manually
    public String collectMetrics() {
        diskService.collectAndSaveDiskMetrics();
        return "Disk metrics collected and were saved successfully";
    }

    // Endpoint to retrieve all collected metrics
    @GetMapping("/getAll")
    public List<DiskMetricsModel> getAllMetrics() {
        return diskMetricsRepository.findAll();
    }
}
