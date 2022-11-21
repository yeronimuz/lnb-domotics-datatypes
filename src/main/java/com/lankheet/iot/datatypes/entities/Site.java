package com.lankheet.iot.datatypes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * A location represents a domotics site.
 */
@Entity(name = "sites")
public class Site
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /** User defined free text */
    String locationText;

    /** All users that have access to a location's data, at least one needs to have admin rights */
    @ManyToMany
    List<DomoticsUser> users;

    /** All sensors in this location */
    @OneToMany
    List<Sensor> sensors;

    /** All actuators in this location */
    @OneToMany
    List<Actuator> actuators;
    
    public Site() {
        // required for JPA
    }
    
    /**
     * Constructor.
     * 
     * @param locationText Free text for the location.
     */
    public Site(String locationText) {
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
