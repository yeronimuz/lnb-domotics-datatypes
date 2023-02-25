package org.lankheet.domiot.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entity that is able to control peripherals at a Location.<BR> Actuator is always regarded separately from a Sensor, even when
 * combined in one case.
 */
@Entity
@Table(name = "actuators", schema = "domiot")
public class ActuatorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private int id;

  private String name;

  private String description;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "actuatorEntity")
  private List<DomiotParameterEntity> parameterEntities;

  @ManyToOne
  @JoinColumn(name = "device_id")
  private DeviceEntity deviceEntity;

  private String mqttTopic;


  public ActuatorEntity() {
    // For JPA
  }

  public List<DomiotParameterEntity> getParameterEntities() {
    return parameterEntities;
  }

  public void setParameterEntities(List<DomiotParameterEntity> parameterEntities) {
    this.parameterEntities = parameterEntities;
  }

  /**
   * Get id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Set id.
   *
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DeviceEntity getDeviceEntity() {
    return deviceEntity;
  }

  public void setDeviceEntity(DeviceEntity deviceEntity) {
    this.deviceEntity = deviceEntity;
  }

  public String getMqttTopic() {
    return mqttTopic;
  }

  public void setMqttTopic(String mqttTopic) {
    this.mqttTopic = mqttTopic;
  }
}
