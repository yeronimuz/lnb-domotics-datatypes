package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.DeviceEntity;
import org.lankheet.domiot.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SensorMapper.class, ActuatorMapper.class, DomiotParameterMapper.class, MqttConfigMapper.class, SerialConfigMapper.class})
public interface DeviceMapper {
    DeviceEntity map(Device device);

    @Mapping(target = "removeParametersItem", ignore = true)
    @Mapping(target = "removeSensorsItem", ignore = true)
    @Mapping(target = "removeActuatorsItem", ignore = true)
    Device map(DeviceEntity deviceEntity);
}
