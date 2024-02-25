package org.lankheet.domiot.domotics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Parameter DTO for the MQTT domain
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DomiotParameterDto {
    private String name;
    private String parameterType;
    private Object value;
    private boolean readonly;
}
