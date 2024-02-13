package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * SensorValue in the MQTT domain
 */
@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@JsonTypeName("SensorValue")
public class SensorValueDto {
    @JsonProperty("sensor")
    private SensorDto sensor;

    @JsonProperty("timestamp")
    private LocalDateTime timeStamp;

    @JsonProperty("value")
    private double value;
}
