package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.SerialConfigEntity;
import org.lankheet.domiot.model.SerialConfig;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SerialConfigMapper {
    SerialConfigEntity map(SerialConfig serialConfig);

    SerialConfig map(SerialConfigEntity serialConfigEntity);
}
