/**
 * 
 */
package com.lankheet.iot.datatypes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sensor types
 */
@Entity
@Table(name = "sensortype")
public enum SensorType {
    TEMPERATURE(1, "temperature"), 
    HUMIDITY(2, "humidity"), 
    POWER_METER(3, "power_meter"), 
    GAS_METER(4, "gas_meter"), 
    GAS_SENSOR(5, "gas_sensor");

    @Id
    private int id;

    private String name;

    private SensorType(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
