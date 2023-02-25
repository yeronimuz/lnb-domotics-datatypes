package org.lankheet.domiot.domotics.datatypes;

import java.util.Date;
import java.util.Objects;

/**
 * A sensor's measured value. It is the object that will be serialized and sent to the backend via
 * an MQTT broker and will be handled by the backend.
 *
 */
public class SensorValue {
    private SensorNode sensorNode;

    private Date timeStamp;

    private int measurementType;

    private double value;

    /**
     * Constructor.
     * 
     * @param sensorNode Origin of the sensor value
     * @param timeStamp When did it occur
     * @param measurementType The int value of the measurement type
     * @param value The sensor value.
     */
    public SensorValue(SensorNode sensorNode, Date timeStamp, int measurementType, double value) {
        if (sensorNode == null) {
            throw new IllegalArgumentException("sensorNode may not be null");
        }
        this.sensorNode = sensorNode;
        this.timeStamp = (Date) timeStamp.clone();
        this.measurementType = measurementType;
        this.value = value;
    }

    public SensorValue() {
        // Rumor goes that Jaxon needs this empty constructor.
    }

    /**
     * Get sensorNode.
     * 
     * @return the sensorNode
     */
    public SensorNode getSensorNode() {
        return sensorNode;
    }

    /**
     * Set sensorNode.
     * 
     * @param sensorNode the sensorNode to set
     */
    public void setSensorNode(SensorNode sensorNode) {
        this.sensorNode = sensorNode;
    }

    /**
     * Get timeStamp.
     * 
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * Set timeStamp.
     * 
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Get measurementType.
     * 
     * @return the measurementType
     */
    public int getMeasurementType() {
        return measurementType;
    }

    /**
     * Set measurementType.
     * 
     * @param measurementType the measurementType to set
     */
    public void setMeasurementType(int measurementType) {
        this.measurementType = measurementType;
    }

    /**
     * Get value.
     * 
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Set value.
     * 
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SensorValue that = (SensorValue) o;
        return measurementType == that.measurementType && Double.compare(that.value, value) == 0 && sensorNode.equals(
            that.sensorNode) && timeStamp.equals(that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorNode, timeStamp, measurementType, value);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SensorValue [sensorNode=" + sensorNode + ", timeStamp=" + timeStamp + ", measurementType="
                + measurementType + ", value=" + value + "]";
    }
}
