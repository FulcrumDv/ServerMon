package com.fulcrum.serverMon.util;

import com.fulcrum.serverMon.model.MemoryMetricsModel;
import com.fulcrum.serverMon.model.DiskMetricsModel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import com.fulcrum.serverMon.model.CpuMetricsModel;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MetricsCollector {

    public static CpuMetricsModel collectedCpuMetrics() {
        SystemInfo systemInformation = new SystemInfo();
        HardwareAbstractionLayer hardwareLayer = systemInformation.getHardware();
        CentralProcessor cpu = hardwareLayer.getProcessor();

        // get inform
        String cpuName = cpu.getProcessorIdentifier().getName();
        double cpuTemp = hardwareLayer.getSensors().getCpuTemperature();
        int coreCount = cpu.getPhysicalProcessorCount();
        double loadPercentage = cpu.getSystemCpuLoad(1000) * 100;
        return new CpuMetricsModel(LocalDateTime.now(), cpuName, coreCount, loadPercentage, cpuTemp);
    }

    public static MemoryMetricsModel collectedRamMetrics() {
        SystemInfo systemInformation = new SystemInfo();
        HardwareAbstractionLayer hardwareLayer = systemInformation.getHardware();
        GlobalMemory RAM = hardwareLayer.getMemory();

        long RamTotal = RAM.getTotal();
        long RamAvailable = RAM.getAvailable();
        double RamUsage = ((RamTotal - RamAvailable) / (double) RamTotal) * 100;

        return new MemoryMetricsModel(LocalDateTime.now(), RamUsage, RamAvailable, RamTotal);

    }

    public List<DiskMetricsModel> collectedDiskMetrics() {
        SystemInfo systemInformation = new SystemInfo();
        HardwareAbstractionLayer hardwareLayer = systemInformation.getHardware();
        List<HWDiskStore> disks = hardwareLayer.getDiskStores();

        // List to hold partition objects
        List<DiskMetricsModel> partitions = new ArrayList<>();

        for (HWDiskStore disk : disks) {
            DiskMetricsModel partition = new DiskMetricsModel();
            partition.setName(disk.getName());
            partition.setTotalSpace(disk.getSize());
            long readBytes = disk.getReadBytes();
            long writeBytes = disk.getWriteBytes();
            // This is a rough estimate of used space based on read and write activity
            // You might want to adjust this calculation based on your specific needs
            long usedSpace = readBytes + writeBytes;
            partition.setUsedSpace(usedSpace);

            // Add the partition to the partitions list, not the disks list
            partitions.add(partition);
        }

        return partitions;
    }

    // collectedMemoryMetrics()
    // collectedGPUMetrics()
    //

}
