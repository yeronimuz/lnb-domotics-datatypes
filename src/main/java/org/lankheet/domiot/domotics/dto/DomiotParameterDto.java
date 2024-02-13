package org.lankheet.domiot.domotics.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
public class DomiotParameterDto {
    private String name;
    private String parameterType;
    private Object value;
}
