package org.lankheet.domiot.domotics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@JsonTypeName("MqttTopic")
public class MqttTopicDto {
    @JsonProperty("type")
    private String type;
    @JsonProperty("path")
    private String path;
}
