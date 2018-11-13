package com.lankheet.iot.datatypes.domotics;

import java.util.Date;

/**
 * A sensor's measured value. It will be converted to a Measurement in the backend.
 *
 */
public class SensorValue {
    private SensorNode sensorNode;

    private Date timeStamp;

    private int measurementType;

    private double value;

    public SensorValue(SensorNode sensorNode, Date timeStamp, int measurementType, double value) {
        this.sensorNode = sensorNode;
        this.timeStamp = (Date) timeStamp.clone();
        this.measurementType = measurementType;
        this.value = value;
    }

    /**
     * Get sensorNode.
     * @return the sensorNode
     */
    public SensorNode getSensorNode() {
        return sensorNode;
    }

    /**
     * Set sensorNode.
     * @param sensorNode the sensorNode to set
     */
    public void setSensorNode(SensorNode sensorNode) {
        this.sensorNode = sensorNode;
    }

    /**
     * Get timeStamp.
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * Set timeStamp.
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Get measurementType.
     * @return the measurementType
     */
    public int getMeasurementType() {
        return measurementType;
    }

    /**
     * Set measurementType.
     * @param measurementType the measurementType to set
     */
    public void setMeasurementType(int measurementType) {
        this.measurementType = measurementType;
    }

    /**
     * Get value.
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Set value.
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
}
