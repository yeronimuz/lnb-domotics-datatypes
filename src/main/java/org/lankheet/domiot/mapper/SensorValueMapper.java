package org.lankheet.domiot.mapper;

import org.lankheet.domiot.domotics.datatypes.SensorValue;
import org.lankheet.domiot.entities.MeasurementType;
import org.lankheet.domiot.entities.SensorValueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SensorMapper.class})
public interface SensorValueMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sensorEntity", source = "sensor")
    SensorValueEntity map(SensorValue sensorValueSource);

    @Mapping(source = "sensorEntity", target = "sensor")
    SensorValue map(SensorValueEntity sensorValueEntitySource);

    default MeasurementType map(int measurementType) {
        for (MeasurementType type : MeasurementType.values()) {
            if (type.getId() == measurementType) {
                return type;
            }
        }
        return null;
    }

    default int map(MeasurementType measurementType) {
        return measurementType.getId();
    }
}
