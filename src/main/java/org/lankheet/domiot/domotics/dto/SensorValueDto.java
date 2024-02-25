package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * SensorValue in the MQTT domain
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorValueDto {
    @JsonProperty("sensor")
    private SensorDto sensor;

    @JsonProperty("timestamp")
    private LocalDateTime timeStamp;

    @JsonProperty("value")
    private double value;
}
