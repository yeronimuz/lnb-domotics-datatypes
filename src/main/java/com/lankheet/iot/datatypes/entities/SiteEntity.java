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
public class SiteEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    /** User defined free text */
    String siteDescription;

    /** All users that have access to a location's data, at least one needs to have admin rights */
    @ManyToMany
    List<DomoticsUserEntity> users;

    /** All sensors in this location */
    @OneToMany
    List<SensorEntity> sensorEntities;

    /** All actuators in this location */
    @OneToMany
    List<ActuatorEntity> actuatorEntities;
    
    public SiteEntity() {
        // required for JPA
    }
    
    /**
     * Constructor.
     * 
     * @param siteDescription Free text for the location.
     */
    public SiteEntity(String siteDescription) {
        this.siteDescription = siteDescription;
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
    public String getSiteDescription() {
        return siteDescription;
    }

    /**
     * Set locationText.
     * @param siteDescription the locationText to set
     */
    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    /**
     * Get userList.
     * @return the userList
     */
    public List<DomoticsUserEntity> getUserList() {
        return users;
    }

    /**
     * Set userList.
     * @param userList the userList to set
     */
    public void setUserList(List<DomoticsUserEntity> userList) {
        this.users = userList;
    }

    /**
     * Get sensorList.
     * @return the sensorList
     */
    public List<SensorEntity> getSensorList() {
        return sensorEntities;
    }

    /**
     * Set sensorList.
     * @param sensorEntityList the sensorList to set
     */
    public void setSensorList(List<SensorEntity> sensorEntityList) {
        this.sensorEntities = sensorEntityList;
    }

    /**
     * Get actuatorList.
     * @return the actuatorList
     */
    public List<ActuatorEntity> getActuatorList() {
        return actuatorEntities;
    }

    /**
     * Set actuatorList.
     * @param actuatorEntityList the actuatorList to set
     */
    public void setActuatorList(List<ActuatorEntity> actuatorEntityList) {
        this.actuatorEntities = actuatorEntityList;
    }
}
