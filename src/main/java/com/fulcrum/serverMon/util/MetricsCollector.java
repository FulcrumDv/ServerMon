package com.fulcrum.serverMon.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import com.fulcrum.serverMon.model.CpuMetricsModel;

import java.time.LocalDateTime;


@Component
public class MetricsCollector {

    public static CpuMetricsModel collectedCpuMetrics(){
        SystemInfo systemInformation = new SystemInfo();
        HardwareAbstractionLayer hardwareLayer = systemInformation.getHardware();
        CentralProcessor cpu = hardwareLayer.getProcessor();

        // get inform
        String cpuName = cpu.getProcessorIdentifier().getName();
        double cpuTemp = hardwareLayer.getSensors().getCpuTemperature();
        int coreCount = cpu.getPhysicalProcessorCount();
        double loadPercentage = cpu.getSystemCpuLoad(1000) * 100;
        return new CpuMetricsModel(LocalDateTime.now(), cpuName, coreCount, loadPercentage, cpuTemp);}

    @Scheduled(fixedRate = 30000)
    public void collectAndSaveMetrics() {
        CpuMetricsModel metrics = collectedCpuMetrics();
    }

    // collectedMemoryMetrics()
    // collectedGPUMetrics()
    //





}
