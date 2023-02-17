package org.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "devices", schema = "domiot")
public class DeviceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  private String manufacturerId;
  private String modelId;
  private String firmwareVersion;
  private String hardwareVersion;
  private String macAddress;

  @OneToOne
  private MqttConfigEntity mqttConfig;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceEntity")
  private List<DomiotParameterEntity> parameters;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceEntity")
  private List<SensorEntity> sensors;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceEntity")
  private List<ActuatorEntity> actuators;

  @ManyToOne
  private SiteEntity siteEntity;

  public List<DomiotParameterEntity> getParameters() {
    return parameters;
  }

  public DeviceEntity() {
    // For JPA
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setParameters(List<DomiotParameterEntity> parameters) {
    this.parameters = parameters;
  }

  public String getManufacturerId() {
    return manufacturerId;
  }

  public void setManufacturerId(String manufacturerId) {
    this.manufacturerId = manufacturerId;
  }

  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public String getFirmwareVersion() {
    return firmwareVersion;
  }

  public void setFirmwareVersion(String firmwareVersion) {
    this.firmwareVersion = firmwareVersion;
  }

  public String getHardwareVersion() {
    return hardwareVersion;
  }

  public void setHardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }

  public MqttConfigEntity getMqttConfig() {
    return mqttConfig;
  }

  public void setMqttConfig(MqttConfigEntity mqttConfig) {
    this.mqttConfig = mqttConfig;
  }

  public String getMacAddress() {
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public List<SensorEntity> getSensors() {
    return sensors;
  }

  public void setSensors(List<SensorEntity> sensors) {
    this.sensors = sensors;
  }

  public List<ActuatorEntity> getActuators() {
    return actuators;
  }

  public void setActuators(List<ActuatorEntity> actuators) {
    this.actuators = actuators;
  }

  public SiteEntity getSiteEntity() {
    return siteEntity;
  }

  public void setSiteEntity(SiteEntity siteEntity) {
    this.siteEntity = siteEntity;
  }
}
