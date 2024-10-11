package com.fulcrum.serverMon.repository;

import com.fulcrum.serverMon.model.MemoryMetricsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryMetricsRepo extends JpaRepository<MemoryMetricsModel, Long> {
    MemoryMetricsModel findTopByOrderByTimestampDesc();
}
