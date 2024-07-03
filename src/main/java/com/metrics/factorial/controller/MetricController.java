package com.metrics.factorial.controller;

import com.metrics.factorial.controller.api.MetricApi;
import com.metrics.factorial.repository.entity.Metric;
import com.metrics.factorial.repository.entity.MetricEntity;
import com.metrics.factorial.service.MetricTSService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@AllArgsConstructor
public class MetricController implements MetricApi {

    private final MetricTSService metricService;

    @Override
    public Metric getMetric(Long id) {
/*
        return metricService.getMetric(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Metric not found"));
*/
        return new Metric();
    }

    @Override
    public Metric createMetric(Metric metric) {
        return metricService.saveMetric(metric);
    }

    @Override
    public List<Metric> getAllMetrics() {
        return metricService.getAllMetrics();
    }

    @Override
    public List<Metric> getMetrics() {
        return List.of();
    }
}
