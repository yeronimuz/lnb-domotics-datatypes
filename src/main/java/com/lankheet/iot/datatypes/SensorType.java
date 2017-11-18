/**
 * 
 */
package com.lankheet.iot.datatypes;

/**
 * Sensor types
 */
public enum SensorType {
    TEMPERATURE(1, "temperature"), 
    HUMIDITY(2, "humidity"), 
    POWER_METER(3, "power_meter"), 
    GAS_METER(4, "gas_meter"), 
    GAS_SENSOR(5, "gas_sensor");

    private int id;

    private String name;

    private SensorType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static SensorType getType(Integer type) {
        SensorType returnType = SensorType.POWER_METER;
        for (SensorType sensorType: SensorType.values()) {
            if (type == sensorType.getId()) {
                returnType = sensorType;
                break;
            }
        }
        return returnType;
    }
}
