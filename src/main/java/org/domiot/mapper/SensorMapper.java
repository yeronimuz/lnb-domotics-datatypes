package org.domiot.mapper;

import org.domiot.entities.SensorEntity;
import org.domiot.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SensorTypeMapper.class, MqttTopicMapper.class, MqttTopicPathMapper.class, DomiotParameterMapper.class})
public interface SensorMapper {
    @Mapping(source = "parameters", target = "parameterEntities")
    @Mapping(source = "mqttTopic.path", target = "mqttTopic")
    @Mapping(target = "sensorTypeValue", ignore = true)
    @Mapping(target = "deviceEntity", ignore = true)
    SensorEntity map(Sensor sensorSource);

    @Mapping(target = "mqttTopic.path", source = "mqttTopic")
    @Mapping(target = "parameters", source = "parameterEntities")
    Sensor map(SensorEntity sensorEntitySource);
}
