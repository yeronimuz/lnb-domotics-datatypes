package org.domiot.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;

/**
 * A sensor is the origin of a measurement
 */
@Entity
@Table(name = "sensors", schema = "domiot")
public class SensorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  @OneToMany(mappedBy = "sensorEntity")
  private List<DomiotParameterEntity> parameterEntities;

  @ManyToOne
  private DeviceEntity deviceEntity;

  @Basic
  private int sensorTypeValue;

  @Transient
  private SensorType sensorType;

  /**
   * The path that will be used to publish sensor values
   */
  private String mqttPath;

  @PostLoad
  void fillTransient() {
    if (sensorTypeValue > 0) {
      this.sensorType = SensorType.getType(sensorTypeValue);
    }
  }

  @PrePersist
  void fillPersistent() {
    if (sensorType != null) {
      this.sensorTypeValue = sensorType.getId();
    }
  }

  private String name;

  private String description;

  private String mqttTopic;

  /**
   * Default constructor required for JPA
   */
  public SensorEntity() {
  }

  /**
   * Constructor.
   *
   * @param sensorType  The type of sensor (SensorType)
   * @param name        The name of this sensor
   * @param description A description (brand, model)
   */
  public SensorEntity(SensorType sensorType, String name, String description) {
    this.sensorType = sensorType;
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
   * Get the name of this sensor.
   *
   * @return The name of this sensor
   */
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public DeviceEntity getDeviceEntity() {
    return deviceEntity;
  }

  public void setDeviceEntity(DeviceEntity deviceEntity) {
    this.deviceEntity = deviceEntity;
  }

  public List<DomiotParameterEntity> getParameterEntities() {
    return parameterEntities;
  }

  public void setParameterEntities(List<DomiotParameterEntity> parameterEntities) {
    this.parameterEntities = parameterEntities;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSensorTypeValue() {
    return sensorTypeValue;
  }

  public void setSensorTypeValue(int sensorTypeValue) {
    this.sensorTypeValue = sensorTypeValue;
  }

  public SensorType getSensorType() {
    return sensorType;
  }

  public void setSensorType(SensorType sensorType) {
    this.sensorType = sensorType;
  }

  public String getMqttPath() {
    return mqttPath;
  }

  public void setMqttPath(String mqttPath) {
    this.mqttPath = mqttPath;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMqttTopic() {
    return mqttTopic;
  }

  public void setMqttTopic(String mqttTopic) {
    this.mqttTopic = mqttTopic;
  }

  @Override
  public String toString() {
    return "SensorEntity{" +
        "id=" + id +
        ", sensorTypeValue=" + sensorTypeValue +
        ", sensorType=" + sensorType +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
