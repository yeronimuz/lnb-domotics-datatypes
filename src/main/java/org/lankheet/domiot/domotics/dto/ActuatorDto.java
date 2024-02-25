package org.lankheet.domiot.domotics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Actuator DTO for the MQTT domain
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActuatorDto {
    private String name;
    private String deviceMac;
    private String mqttTopic;
    private List<DomiotParameterDto> parameterEntities;
}
