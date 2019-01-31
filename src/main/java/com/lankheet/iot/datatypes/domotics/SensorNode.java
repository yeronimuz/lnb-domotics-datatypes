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

    public SensorNode() {
        // TODO Auto-generated constructor stub
    }
    
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SensorNode [sensorMac=" + sensorMac + ", sensorType=" + sensorType + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sensorMac == null) ? 0 : sensorMac.hashCode());
        result = prime * result + sensorType;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SensorNode other = (SensorNode) obj;
        if (sensorMac == null) {
            if (other.sensorMac != null)
                return false;
        } else if (!sensorMac.equals(other.sensorMac))
            return false;
        if (sensorType != other.sensorType)
            return false;
        return true;
    }
}
