package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.DeviceEntity;
import org.lankheet.domiot.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MqttTopicMapper.class, SensorMapper.class, ActuatorMapper.class, DomiotParameterMapper.class, MqttConfigMapper.class, SerialConfigMapper.class})
public interface DeviceMapper {
    @Mapping(target = "siteEntity", ignore = true)
    DeviceEntity map(Device deviceDto);

    Device map(DeviceEntity deviceEntity);

    List<Device> mapToDto(List<DeviceEntity> deviceEntities);

    List<DeviceEntity> mapToEntities(List<Device> deviceEntities);
}
