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

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * A location represents a domotics site.
 */
@Entity(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /** User defined free text */
    String locationText;

    /** All users that have access to a location's data */
    @ManyToMany
    List<DomoticsUser> users;

    /** All sensors in this location */
    @OneToMany
    List<Sensor> sensors;

    /** All actuators in this location */
    @OneToMany
    List<Actuator> actuators;
    
    public Location() {
        // required for JPA
    }
    
    /**
     * Constructor.
     * 
     * @param locationText Free text for the location.
     */
    public Location(String locationText) {
        this.locationText = locationText;
    }


    /**
     * Get id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get locationText.
     * @return the locationText
     */
    public String getLocationText() {
        return locationText;
    }

    /**
     * Set locationText.
     * @param locationText the locationText to set
     */
    public void setLocationText(String locationText) {
        this.locationText = locationText;
    }

    /**
     * Get userList.
     * @return the userList
     */
    public List<DomoticsUser> getUserList() {
        return users;
    }

    /**
     * Set userList.
     * @param userList the userList to set
     */
    public void setUserList(List<DomoticsUser> userList) {
        this.users = userList;
    }

    /**
     * Get sensorList.
     * @return the sensorList
     */
    public List<Sensor> getSensorList() {
        return sensors;
    }

    /**
     * Set sensorList.
     * @param sensorList the sensorList to set
     */
    public void setSensorList(List<Sensor> sensorList) {
        this.sensors = sensorList;
    }

    /**
     * Get actuatorList.
     * @return the actuatorList
     */
    public List<Actuator> getActuatorList() {
        return actuators;
    }

    /**
     * Set actuatorList.
     * @param actuatorList the actuatorList to set
     */
    public void setActuatorList(List<Actuator> actuatorList) {
        this.actuators = actuatorList;
    }
}
