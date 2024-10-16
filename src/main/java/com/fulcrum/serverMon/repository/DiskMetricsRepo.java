package com.fulcrum.serverMon.repository;

import com.fulcrum.serverMon.model.DiskMetricsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiskMetricsRepo extends JpaRepository<DiskMetricsModel, Long> {
	DiskMetricsRepo findTopByOrderByTimestampDesc();
}
