package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.MqttConfigEntity;
import org.lankheet.domiot.model.MqttConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class })
public interface MqttConfigMapper {
    @Mapping(target = "mqttTopicEntities", source = "topics")
    MqttConfigEntity map(MqttConfig mqttConfig);

    @Mapping(target = "removeTopicsItem", ignore = true)
    @Mapping(source = "mqttTopicEntities", target = "topics")
    MqttConfig map(MqttConfigEntity mqttConfigEntity);
}
