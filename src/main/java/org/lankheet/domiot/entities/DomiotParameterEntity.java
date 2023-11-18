package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "domiot_parameters", schema = "domiot")
public class DomiotParameterEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "device_id")
  private DeviceEntity deviceEntity;

  @ManyToOne
  @JoinColumn(name = "sensor_id")
  private SensorEntity sensorEntity;

  @ManyToOne
  @JoinColumn(name = "actuator_id")
  private ActuatorEntity actuatorEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DeviceEntity getDeviceEntity() {
    return deviceEntity;
  }

  public void setDeviceEntity(DeviceEntity deviceEntity) {
    this.deviceEntity = deviceEntity;
  }

  public SensorEntity getSensorEntity() {
    return sensorEntity;
  }

  public void setSensorEntity(SensorEntity sensorEntity) {
    this.sensorEntity = sensorEntity;
  }

  public ActuatorEntity getActuatorEntity() {
    return actuatorEntity;
  }

  public void setActuatorEntity(ActuatorEntity actuatorEntity) {
    this.actuatorEntity = actuatorEntity;
  }

}
