package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.DomiotParameterEntity;
import org.lankheet.domiot.model.DomiotParameter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomiotParameterMapper {
    DomiotParameter map(DomiotParameterEntity domiotParameterEntity);

    @Mapping(target = "deviceEntity", ignore = true)
    @Mapping(target = "sensorEntity", ignore = true)
    @Mapping(target = "actuatorEntity", ignore = true)
    DomiotParameterEntity map(DomiotParameter domiotParameter);

    List<DomiotParameter> map(List<DomiotParameterEntity> domiotParameterEntities);
}
