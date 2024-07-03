package com.metrics.factorial.controller.api;

import com.metrics.factorial.repository.entity.Metric;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Tag(name = "/api/v1", description = "Metric API")
@RequestMapping(
        value = "/api/v1/metrics",
        produces = APPLICATION_JSON_VALUE,
        consumes = APPLICATION_JSON_VALUE
)
@RestController
public interface MetricApi {

    @GetMapping("/{id}")
    @Operation(summary = "Get metric by id")
    @Parameter(name = "id", description = "Metric ID", required = true)
    Metric getMetric(@PathVariable Long id);

    @PostMapping("/")
    @Operation(summary = "Add a new metric")
    Metric createMetric(@RequestBody Metric metric);

    @GetMapping("/all")
    @Operation(summary = "Get all metrics")
    List<Metric> getAllMetrics();


    @GetMapping("/")
    @Operation(summary = "Get last 10 metrics")
    List<Metric> getMetrics();
}
