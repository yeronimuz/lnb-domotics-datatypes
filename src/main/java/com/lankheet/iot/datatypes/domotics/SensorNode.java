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
