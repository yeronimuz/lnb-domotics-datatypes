package org.domiot.mapper;

import org.domiot.entities.MqttTopicEntity;
import org.domiot.model.MqttTopic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // (uses = MqttConfigMapper.class)
public interface MqttTopicMapper {
    @Mapping(target = "mqttConfigEntity", ignore = true)
    MqttTopicEntity map(MqttTopic mqttTopic);

    MqttTopic map(MqttTopicEntity mqttTopicEntity);

    List<MqttTopicEntity> map(List<MqttTopic> mqttTopics);
}
