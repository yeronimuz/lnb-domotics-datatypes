package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mqtt topic DTO for the MQTT domain
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MqttTopicDto {
    @JsonProperty("type")
    private String type;
    @JsonProperty("path")
    private String path;
}
