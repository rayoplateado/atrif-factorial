package com.metrics.factorial.service;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.metrics.factorial.repository.entity.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricTSService {

    @Autowired
    private InfluxDBClient influxDBClient;

    @Value("${influxdb.bucket}")
    private String bucket;

    @Value("${influxdb.org}")
    private String org;

    public Metric saveMetric(Metric metric) {
        WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();
        Point point = Point.measurement("metrics")
                .addTag("name", metric.getName())
                .addField("value", metric.getValue())
                .time(metric.getTimestamp(), WritePrecision.MS);

        writeApi.writePoint(bucket, org, point);
        return metric;
    }

    public List<Metric> getAllMetrics() {
        var queryApi = influxDBClient.getQueryApi();
        String flux = String.format("from(bucket: \"%s\") |> range(start: -30d) |> filter(fn: (r) => r._measurement == \"metrics\")", bucket);

        List<FluxTable> tables = queryApi.query(flux, org);
        List<Metric> metrics = new ArrayList<>();

        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
                Metric metric = new Metric();
                metric.setName(record.getValueByKey("name").toString());
                metric.setValue(Double.parseDouble(record.getValueByKey("_value").toString()));
                metric.setTimestamp(record.getTime());
                metrics.add(metric);
            }
        }

        return metrics;
    }

//    public MetricAverages getMetricAverages() {
        // TODO: Implement the logic to calculate averages
        // ...
//    }
}
