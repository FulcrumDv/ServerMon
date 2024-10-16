package com.fulcrum.serverMon.controller;

import com.fulcrum.serverMon.model.MemoryMetricsModel;
import com.fulcrum.serverMon.repository.MemoryMetricsRepo;
import com.fulcrum.serverMon.service.MemoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ram-metrics/")
class MemoryController {

    private MemoryService metricsService;
    private MemoryMetricsRepo MetricsRepo;

    public MemoryController(MemoryService metricsService, MemoryMetricsRepo MetricsRepo) {
        this.metricsService = metricsService;
        this.MetricsRepo = MetricsRepo;
    }

    @GetMapping("/getAll")
    public List<MemoryMetricsModel> getAllRamInfo() {
        return MetricsRepo.findAll();
    }

}





