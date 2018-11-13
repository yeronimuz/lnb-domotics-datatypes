package com.lankheet.iot.datatypes.conversion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.lankheet.iot.datatypes.entities.SensorType;

/**
 * Converter for storing SensorType enum as integer in the database and vice versa.
 */
@Converter(autoApply = true)
public class SensorTypeConverter implements AttributeConverter<SensorType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SensorType type) {
        return type.getId();
    }

    @Override
    public SensorType convertToEntityAttribute(Integer type) {
        return SensorType.getType(type);
    }
}
