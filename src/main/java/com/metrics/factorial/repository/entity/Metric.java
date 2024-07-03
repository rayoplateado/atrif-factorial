package com.metrics.factorial.repository.entity;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Metric {

    private String name;
    private Double value;
    private Instant timestamp;
}
