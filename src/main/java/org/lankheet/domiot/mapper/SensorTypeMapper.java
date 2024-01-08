package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.SensorType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorTypeMapper {
    default SensorType map(int sensorType) {
        for (SensorType type : SensorType.values()) {
            if (type.getId() == sensorType) {
                return type;
            }
        }
        return null;
    }

    default int map(SensorType sensorType) {
        return sensorType.getId();
    }
}
