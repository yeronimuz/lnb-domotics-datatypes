package com.lankheet.iot.datatypes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity that is able to control peripherals at a Location.<BR>
 * Actuator is always regarded separately from a Sensor, even when combined in one case.
 */
@Entity(name = "actuators")
public class Actuator {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @ManyToOne
    private Location location;
    
    // TODO: Accompanied sensor (0 or more)
    // TODO: Status
    // TODO: params, values
    
    public Actuator() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Get id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

     /**
     * Get the location.
     * @return location
     */
    public Location getLocation() {
        return location;
    }
}
