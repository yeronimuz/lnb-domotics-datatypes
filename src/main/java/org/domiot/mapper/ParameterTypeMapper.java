package org.domiot.mapper;

import org.domiot.model.DomiotParameter.ParameterTypeEnum;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParameterTypeMapper {
    default ParameterTypeEnum map(String parameterType) {
        for (ParameterTypeEnum type : ParameterTypeEnum.values()) {
            if (type.getValue().equals(parameterType)) {
                return type;
            }
        }
        return null;
    }

    default String map(ParameterTypeEnum parameterTypeEnum) {
        return parameterTypeEnum.getValue();
    }

}
