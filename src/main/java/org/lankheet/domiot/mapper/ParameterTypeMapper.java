package org.lankheet.domiot.mapper;

import org.lankheet.domiot.model.DomiotParameter.ParameterTypeEnum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParameterTypeMapper {
    default ParameterTypeEnum map(String parameterType) {
        for (ParameterTypeEnum type : ParameterTypeEnum.values()) {
            if (type.value().equals(parameterType)) {
                return type;
            }
        }
        return null;
    }

    default String map(ParameterTypeEnum parameterTypeEnum) {
        return parameterTypeEnum.value();
    }

}
