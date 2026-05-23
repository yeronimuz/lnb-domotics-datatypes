package org.domiot.mapper;

import org.domiot.entities.SerialConfigEntity;
import org.domiot.model.SerialConfig;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SerialConfigMapper {
    SerialConfigEntity map(SerialConfig serialConfig);

    SerialConfig map(SerialConfigEntity serialConfigEntity);
}
