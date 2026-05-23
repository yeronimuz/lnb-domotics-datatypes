package org.domiot.mapper;

import org.domiot.entities.ActuatorEntity;
import org.domiot.model.Actuator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class, MqttTopicPathMapper.class, DomiotParameterMapper.class})
public interface ActuatorMapper {
    @Mapping(target = "parameters", source = "parameterEntities")
    Actuator map(ActuatorEntity actuatorEntity);

    @Mapping(target = "deviceEntity", ignore = true)

    @Mapping(target = "parameterEntities", source = "parameters")
    ActuatorEntity map(Actuator actuator);
}
