package com.fulcrum.serverMon.controller;

import com.fulcrum.serverMon.model.CpuMetricsModel;
import com.fulcrum.serverMon.repository.CpuMetricsRepo;
import com.fulcrum.serverMon.service.CpuService;
import com.fulcrum.serverMon.service.CpuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cpu-metrics")
public class MetricsController {

    private final CpuService cpuMetricsService;
    private final CpuMetricsRepo cpuMetricsRepository;

    // Constructor injection of dependencies
    public MetricsController(CpuService cpuMetricsService, CpuMetricsRepo cpuMetricsRepository) {
        this.cpuMetricsService =        cpuMetricsService;
        this.cpuMetricsRepository = cpuMetricsRepository;
    }

    @PostMapping("/collect") // collect and save manually
    public String collectMetrics() {
        CpuService.collectAndSaveMetrics();
        return "CPU metrics collected and were saved successfully";
    }

    // Endpoint to retrieve all collected metrics
    @GetMapping("/getall")
    public List<CpuMetricsModel> getAllMetrics() {
        return cpuMetricsRepository.findAll();
    }


}