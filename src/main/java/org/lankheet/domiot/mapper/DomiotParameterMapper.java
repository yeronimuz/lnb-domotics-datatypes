package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.DomiotParameterEntity;
import org.lankheet.domiot.model.DomiotParameter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomiotParameterMapper {
    DomiotParameter map(DomiotParameterEntity domiotParameterEntity);

    DomiotParameterEntity map(DomiotParameter domiotParameter);

    List<DomiotParameter> map(List<DomiotParameterEntity> domiotParameterEntities);
}
