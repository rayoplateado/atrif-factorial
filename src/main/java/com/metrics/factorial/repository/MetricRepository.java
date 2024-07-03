package com.metrics.factorial.repository;

import com.metrics.factorial.repository.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetricRepository extends JpaRepository<MetricEntity, Long> {
    List<MetricEntity> findAllByOrderByTimestampAsc();
}

