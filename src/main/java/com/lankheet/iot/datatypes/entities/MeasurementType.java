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

package com.lankheet.iot.datatypes.entities;

import javax.persistence.Entity;

/**
 * The types of measurements in P1 datagram
 */
@Entity
public enum MeasurementType {
	// From SmartMeter
	PRODUCED_POWER_T1(1, "Produced power T1", "kW"), 
	PRODUCED_POWER_T2(2, "Produced power T2", "kW"), 
	CONSUMED_POWER_T1(3, "Consumed power T1", "kW"), 
	CONSUMED_POWER_T2(4, "Consumed power T2", "kW"), 
	ACTUAL_CONSUMED_POWER(5, "Actual consumed power", "kW"), 
	ACTUAL_PRODUCED_POWER(6, "Actual consumed power", "kW"), 
	CONSUMED_GAS(7, "Consumed gas", "m3"),

	// From iot network
	TEMPERATURE(8, "Temperature", "Deg.C"), 
	HUMIDITY(9, "Humidity", "%"), 
	CONSUMED_WATER(10, "water consumed", "m3"),
    UNKNOWN(99, "sentinel", "none"),
    ;

	int id;
	
	String name;

	String unit;

	MeasurementType(int id, String name, String unit) {
		this.id = id;
		this.name = name;
		this.unit = unit;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public static MeasurementType getType(Integer type) {
	    MeasurementType returnType = MeasurementType.TEMPERATURE;
	    for (MeasurementType measType: MeasurementType.values()) {
	        if (type == measType.getId()) {
	            returnType = measType;
	            break;
	        }
	    }
	    return returnType;
	}
}
