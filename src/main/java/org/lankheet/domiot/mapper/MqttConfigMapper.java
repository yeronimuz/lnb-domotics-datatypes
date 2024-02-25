package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.MqttConfigEntity;
import org.lankheet.domiot.model.MqttConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class })
public interface MqttConfigMapper {
    @Mapping(target = "mqttTopicEntities", source = "topics")
    @Mapping(target = "siteEntity", ignore = true)
    @Mapping(target = "userEntity.id", source = "userId")
    MqttConfigEntity map(MqttConfig mqttConfig);

    @Mapping(source = "userEntity.id", target = "userId")
    @Mapping(target = "removeTopicsItem", ignore = true)
    @Mapping(source = "mqttTopicEntities", target = "topics")
    MqttConfig map(MqttConfigEntity mqttConfigEntity);
}
