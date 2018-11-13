package com.lankheet.iot.datatypes.domotics;

/**
 * A sensor node is the origin of a measurement in the Domotics domain.<BR>
 * Currently, a sensor may be a combined sensor. We do not model this explicitly.<BR>
 * A measurement of different types can come from one sensor. Each sensor can have multiple sensor
 * nodes.<BR>
 * All these combined nodes have in common is the sensor's MAC address.
 */
public class SensorNode {

    private String sensorMac;

    private int sensorType;

    /**
     * Constructor.
     * 
     * @param id The sensor id
     * @param type The type of sensor (SensorType)
     */
    public SensorNode(String sensorMac, int sensorType) {
        this.sensorMac = sensorMac;
        this.sensorType = sensorType;
    }

    /**
     * Get the type.
     * 
     * @return The type of the sensor (enum)
     */
    public int getSensorType() {
        return sensorType;
    }

    /**
     * Get sensorMAC.
     * 
     * @return the sensorMAC address
     */
    public String getSensorMac() {
        return sensorMac;
    }
}
