package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.SensorEntity;
import org.lankheet.domiot.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SensorTypeMapper.class, MqttTopicMapper.class, MqttTopicPathMapper.class, DomiotParameterMapper.class})
public interface SensorMapper {
    @Mapping(source = "parameters", target = "parameterEntities")
    @Mapping(source = "type", target = "sensorType")
    @Mapping(source = "mqttTopic.path", target = "mqttPath")
    @Mapping(target="sensorTypeValue", ignore = true)
    SensorEntity map(Sensor sensorSource);

    @Mapping(target = "removeParametersItem", ignore = true)
    @Mapping(target = "parameters", source = "parameterEntities")
    @Mapping(target = "type", source = "sensorType")
    @Mapping(target = "mqttTopic.path", source = "mqttPath")
    Sensor map(SensorEntity sensorEntitySource);
}
