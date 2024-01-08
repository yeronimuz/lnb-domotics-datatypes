package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.MqttTopicEntity;
import org.lankheet.domiot.model.MqttTopic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") // (uses = MqttConfigMapper.class)
public interface MqttTopicMapper {
    MqttTopicEntity map(MqttTopic mqttTopic);

    MqttTopic map(MqttTopicEntity mqttTopicEntity);

    List<MqttTopicEntity> map(List<MqttTopic> mqttTopics);
}
