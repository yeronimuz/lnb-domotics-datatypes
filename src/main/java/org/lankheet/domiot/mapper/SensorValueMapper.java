package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.MeasurementType;
import org.lankheet.domiot.entities.SensorValueEntity;
import org.lankheet.domiot.model.SensorValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SensorMapper.class})
public interface SensorValueMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sensorId", source = "sensorId")
    @Mapping(target = "timeStamp", source = "timestamp")
    SensorValueEntity map(SensorValue sensorValueSource);

    @Mapping(source = "sensorId", target = "sensorId")
    @Mapping(target = "timestamp", source = "timeStamp")
    SensorValue map(SensorValueEntity sensorValueEntitySource);

    List<SensorValue> map(List<SensorValueEntity> sensorValueEntities);

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
