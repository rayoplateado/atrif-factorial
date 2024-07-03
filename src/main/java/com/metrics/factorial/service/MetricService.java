package com.metrics.factorial.service;

import com.metrics.factorial.repository.MetricRepository;
import com.metrics.factorial.repository.entity.MetricEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MetricService {

    private final MetricRepository metricRepository;

    public MetricEntity create(MetricEntity metricEntity) {
//        metric.setTimestamp(LocalDateTime.now());
        return metricRepository.save(metricEntity);
    }

    public List<MetricEntity> findAll() {
        log.info("Get all metrics");
        return metricRepository.findAllByOrderByTimestampAsc();
    }

    public Optional<MetricEntity> getMetric(Long id) {
        log.info("Get metric by ID: {}", id);
        return metricRepository.findById(id);
    }
}
