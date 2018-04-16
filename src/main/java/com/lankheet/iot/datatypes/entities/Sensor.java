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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * A sensor is the origin of a measurement.<BR>
 * Currently, a sensor may be a combined sensor. We do not model this.<BR>
 * A measurement of different types can come from one sensor.
 */
@Entity(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SensorType sensorType;
    
    private String macAddress;

    private String name;

    private String description;

    @ManyToOne
    private Location location;

    /** Default constructor required for JPA */
    public Sensor() {}

    /**
     * Constructor.
     * 
     * @param id The sensor id
     * @param sensorType The type of sensor (SensorType)
     * @param name The name of this sensor
     * @param description A description (brand, model)
     */
    public Sensor(SensorType sensorType, String macAddress, String name, String description) {
        this.sensorType = sensorType;
        this.macAddress = macAddress;
        this.name = name;
        this.description = description;
    }

    /**
     * Get the id.
     * 
     * @return the unique id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the type.
     * 
     * @return The type of the sensor (enum)
     */
    public SensorType getType() {
        return sensorType;
    }

    /**
     * Get the name of this sensor.
     * 
     * @return The name of this sensor
     */
    public String getName() {
        return name;
    }

    /**
     * Get the brand and model of this sensor description.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the location of this sensor
     * 
     * @return location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set location.
     * 
     * @param location The location of this sensor
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Get macAddress.
     * @return the macAddress
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Set macAddress.
     * @param macAddress the macAddress to set
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Sensor [id=" + id + ", sensorType=" + sensorType + ", macAddress=" + macAddress + ", name=" + name
                + ", description=" + description + ", location=" + location + "]";
    }
}
