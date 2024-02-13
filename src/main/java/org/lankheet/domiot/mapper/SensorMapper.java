package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.SensorEntity;
import org.lankheet.domiot.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SensorTypeMapper.class, MqttTopicMapper.class, MqttTopicPathMapper.class, DomiotParameterMapper.class})
public interface SensorMapper {
    @Mapping(source = "parameters", target = "parameterEntities")
    @Mapping(source = "type", target = "sensorType")
    @Mapping(target = "sensorTypeValue", ignore = true)
    @Mapping(target = "deviceEntity", ignore = true)
    SensorEntity map(Sensor sensorSource);

    @Mapping(target = "removeParametersItem", ignore = true)
    @Mapping(target = "parameters", source = "parameterEntities")
    @Mapping(target = "type", source = "sensorType")
    Sensor map(SensorEntity sensorEntitySource);
}
