package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.ActuatorEntity;
import org.lankheet.domiot.model.Actuator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class, MqttTopicPathMapper.class, DomiotParameterMapper.class})
public interface ActuatorMapper {
    @Mapping(target = "removeParametersItem", ignore = true)
    @Mapping(target = "parameters", source = "parameterEntities")
    Actuator map(ActuatorEntity actuatorEntity);

    @Mapping(target = "deviceEntity", ignore = true)

    @Mapping(target = "parameterEntities", source = "parameters")
    ActuatorEntity map(Actuator actuator);
}
