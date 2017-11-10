package com.lankheet.iot.datatypes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private SensorType type;
	
	private String name;
	
	private String description;

	public Sensor(SensorType type, String name, String description) {
		super();
		this.type = type;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public SensorType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
}
