package org.domiot.mapper;

import org.domiot.entities.MqttConfigEntity;
import org.domiot.model.MqttConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class})
public interface MqttConfigMapper {
    @Mapping(target = "mqttTopicEntities", source = "topics")
    @Mapping(target = "siteEntity", ignore = true)
    @Mapping(target = "userEntity.id", source = "userId")
    MqttConfigEntity map(MqttConfig mqttConfig);

    @Mapping(source = "userEntity.id", target = "userId")
    @Mapping(source = "mqttTopicEntities", target = "topics")
    MqttConfig map(MqttConfigEntity mqttConfigEntity);
}
