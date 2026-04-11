package org.lankheet.domiot.mapper;

import java.util.List;

import org.lankheet.domiot.domotics.dto.SensorSummaryDto;
import org.lankheet.domiot.entities.SensorSummaryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TimeSeriesMapper.class)
public interface SensorSummaryMapper {

    @Mapping(source = "periodType", target = "periodType")
    @Mapping(source = "timeSeriesData", target = "timeSeries")
    SensorSummaryDto map(SensorSummaryEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "timeSeries", target = "timeSeriesData")
    SensorSummaryEntity map(SensorSummaryDto dto);

    List<SensorSummaryDto> map(List<SensorSummaryEntity> entities);
}
