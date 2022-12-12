package com.lankheet.iot.datatypes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * A sensor is the origin of a measurement.<BR>
 * Currently, a sensor may be a combined sensor. We do not model this.<BR>
 * A measurement of different types can come from one sensor.
 */
@Entity(name = "sensors")
public class SensorEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private SensorType sensorType;
    
    private String macAddress;

    private String name;

    private String description;

    @ManyToOne
    private SiteEntity siteEntity;

    /** Default constructor required for JPA */
    public SensorEntity() {}

    /**
     * Constructor.
     * 
     * @param sensorType The type of sensor (SensorType)
     * @param name The name of this sensor
     * @param description A description (brand, model)
     */
    public SensorEntity(SensorType sensorType, String macAddress, String name, String description) {
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
    public SiteEntity getLocation() {
        return siteEntity;
    }

    /**
     * Set location.
     * 
     * @param siteEntity The location of this sensor
     */
    public void setLocation(SiteEntity siteEntity) {
        this.siteEntity = siteEntity;
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
                + ", description=" + description + ", location=" + siteEntity + "]";
    }
}
