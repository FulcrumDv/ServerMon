package com.example.serverMon.controller;

import com.example.serverMon.dto.MetricsDTO;
import com.example.serverMon.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")  // Adjust the port if your React app runs on a different port
@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping
    public List<MetricsDTO> getMetrics() {
        return metricsService.getMetrics();
    }
}