package com.lankheet.iot.datatypes.entities;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Sensor types.
 */
public enum SensorType {
    TEMPERATURE(1, "temperature"),
    HUMIDITY(2, "humidity"),
    POWER_METER(3, "power_meter"),
    GAS_METER(4, "gas_meter"),
    GAS_SENSOR(5, "gas_sensor");

    private int id;

    private String description;

    private SensorType(int id, String name) {
        this.id = id;
        this.description = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Get type by Id.
     * 
     * @param type The type.id to lookup.
     * @return The SensorType that matches the type.id or null if not found
     */
    @JsonValue
    public static SensorType getType(Integer type) {
        SensorType returnType = null;
        for (SensorType sensorType : SensorType.values()) {
            if (type == sensorType.getId()) {
                returnType = sensorType;
                break;
            }
        }
        return returnType;
    }
}
