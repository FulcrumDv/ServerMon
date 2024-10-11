package com.fulcrum.serverMon.service;
import com.fulcrum.serverMon.model.CpuMetricsModel;
public interface CpuServiceInterface {
    // Need to get the latest metrics
    CpuMetricsModel getCpuMetricsToDate();
    void saveCpuMetrics(CpuMetricsModel CpuMetrics);

}
