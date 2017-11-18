package com.lankheet.iot.datatypes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor {

    @Id
    private int id;

    private Integer type;

    private String name;

    private String description;

    /** Default constructor required for JPA */
    public Sensor() {}

    public Sensor(Integer type, String name, String description) {
        super();
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public SensorType getType() {
        return SensorType.getType(this.type);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
