package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * SensorDto is the Mqtt domain entity. It will be matched against the deviceMac at the backend.
 */
@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@JsonTypeName("Sensor")
public class SensorDto {
    @JsonProperty("deviceMac")
    private String deviceMac;
    @JsonProperty("topic")
    private MqttTopicDto mqttTopic;
    @JsonProperty("type")
    private SensorTypeDto sensorType;
    @JsonProperty("parameters")
    private List<DomiotParameterDto> parameterEntities;

    public SensorDto addParameter(DomiotParameterDto parameter) {
        if (parameterEntities == null) {
            parameterEntities = new ArrayList<>();
        }
        parameterEntities.add(parameter);
        return this;
    }
}
