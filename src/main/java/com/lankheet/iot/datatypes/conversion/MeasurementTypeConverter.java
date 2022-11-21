package com.lankheet.iot.datatypes.conversion;

import com.lankheet.iot.datatypes.entities.MeasurementType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converter for storing MeasurementType enum as integer in the database and vice versa.
 */
@Converter(autoApply = true)
public class MeasurementTypeConverter implements AttributeConverter<MeasurementType, Integer>
{

    @Override
    public Integer convertToDatabaseColumn(MeasurementType type) {
        return type.getId();
    }

    @Override
    public MeasurementType convertToEntityAttribute(Integer type) {
        return MeasurementType.getType(type);
    }
}
