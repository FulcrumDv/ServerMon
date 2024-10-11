package com.fulcrum.serverMon.repository;

import com.fulcrum.serverMon.model.CpuMetricsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuMetricsRepo extends JpaRepository<CpuMetricsModel, Long> {
    CpuMetricsModel findTopByOrderByTimestampDesc();
}
