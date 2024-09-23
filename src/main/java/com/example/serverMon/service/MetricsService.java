package com.example.serverMon.service;

import com.example.serverMon.dto.MetricsDTO;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetricsService {

    public List<MetricsDTO> getMetrics() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        List<MetricsDTO> metrics = new ArrayList<>();

        // CPU Usage
        CentralProcessor processor = hal.getProcessor();
        double cpuUsage = processor.getSystemCpuLoad(1000) * 100;
        metrics.add(new MetricsDTO("CPU USAGE", String.format("%.2f%%", cpuUsage), cpuUsage > 50, String.format("%.1f%%", cpuUsage)));

        // RAM Usage
        GlobalMemory memory = hal.getMemory();
        long totalMemory = memory.getTotal();
        long usedMemory = totalMemory - memory.getAvailable();
        double ramUsage = (double) usedMemory / totalMemory * 100;
        metrics.add(new MetricsDTO("RAM USAGE", String.format("%.2f%%", ramUsage), ramUsage > 50, String.format("%.1f%%", ramUsage)));

        // TODO: Add GPU and Disk usage metrics

        return metrics;
    }
}
