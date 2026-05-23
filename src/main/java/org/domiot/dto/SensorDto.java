package org.domiot.dto;

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
    /**
     * The sensorId is determined by the backend after storing the sensor in the database
     */
    @JsonProperty
    private long sensorId;
    /**
     * A sensor is identified by the device's MAC and the sensorType
     */
    @JsonProperty("deviceMac")
    private String deviceMac;
    /**
     * Per sensor, the topic must be unique
     */
    @JsonProperty("topic")
    private MqttTopicDto mqttTopic;
    /**
     * A sensor is identified by the device's MAC and the sensorType
     */
    @JsonProperty("type")
    private SensorTypeDto sensorType;
    /**
     * The sensor is configured by setting parameters
     */
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
