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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A sensor is the origin of a measurement.<BR>
 * Currently, a sensor may be a combined sensor. We do not model this.<BR>
 * A measurement of different types can come from one sensor.
 */
@Entity
public class Sensor {

    @Id
    @JsonProperty
    private int id;

    /** reference to SensorType.id */
    // @JsonProperty
    private Integer type;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @ManyToOne
    @JsonProperty
    private Location location;

    /** Default constructor required for JPA */
    public Sensor() {}

    /**
     * Constructor.
     * 
     * @param id The sensor id
     * @param type The type of sensor (SensorType)
     * @param name The name of this sensor
     * @param description A description (brand, model)
     */
    public Sensor(@JsonProperty("id") int id, @JsonProperty("type") Integer type, @JsonProperty("name") String name,
            @JsonProperty("description") String description) {
        super();
        this.id = id;
        this.type = type;
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
    @JsonProperty
    public SensorType getType() {
        return SensorType.getType(this.type);
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
}
