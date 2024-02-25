package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * SensorDto is the Mqtt domain entity. It will be matched against the deviceMac at the backend.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {
    @JsonProperty("deviceMac")
    private String deviceMac;
    @JsonProperty("topic")
    private MqttTopicDto mqttTopic;
    @JsonProperty("type")
    private SensorTypeDto sensorType;
    @JsonProperty("parameters")
    private List<DomiotParameterDto> parameters;

    public SensorDto addParameter(DomiotParameterDto parameter) {
        if (parameters == null) {
            parameters = new ArrayList<>();
        }
        parameters.add(parameter);
        return this;
    }
}
