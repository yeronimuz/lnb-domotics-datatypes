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

package com.lankheet.iot.datatypes;

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
    
    /**
     * Get type by Id.
     * @param type The type.id to lookup.
     * @return The SensorType that matches the type.id or null if not found
     */
    public static SensorType getType(Integer type) {
        SensorType returnType = null;
        for (SensorType sensorType: SensorType.values()) {
            if (type == sensorType.getId()) {
                returnType = sensorType;
                break;
            }
        }
        return returnType;
    }
}
