/**
 * MIT License
 * 
 * Copyright (c) 2017 Lankheet Software and System Solutions
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
