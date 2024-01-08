package org.lankheet.domiot.mapper;

import org.lankheet.domiot.model.MqttTopic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MqttTopicPathMapper {
    default String map(MqttTopic mqttTopic) {
        return mqttTopic.getPath();
    }

    default MqttTopic map(String path) {
        return new MqttTopic().path(path);
    }
}
