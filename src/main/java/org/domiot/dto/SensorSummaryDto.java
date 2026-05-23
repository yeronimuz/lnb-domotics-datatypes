package org.domiot.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorSummaryDto {

    private Integer sensorId;

    private String periodType; // Or use enum directly if your frontend expects it

    private LocalDateTime periodStart;

    private Double minValue;

    private Double maxValue;

    private Double avgValue;

    private List<Double> timeSeries; // Decoded from MessagePack or JSON

}