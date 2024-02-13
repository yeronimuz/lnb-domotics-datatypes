package org.lankheet.domiot.domotics.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
public class ActuatorDto {
    private String name;
    private String deviceMac;
    private String mqttTopic;
    private List<DomiotParameterDto> parameterEntities;
}
