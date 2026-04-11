package org.lankheet.domiot.domotics.dto;


import java.time.LocalDateTime;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.lankheet.domiot.entities.PeriodType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorChartDataDto {
    private HashMap<Integer, SensorSummaryDto> combinedSensorGraphData;

    private PeriodType periodType;

    private LocalDateTime periodStart;
}
