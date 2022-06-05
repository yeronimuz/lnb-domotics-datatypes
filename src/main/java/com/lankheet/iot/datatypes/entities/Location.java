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
