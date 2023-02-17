package org.domiot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * A location represents a domotics site.
 */
@Entity
@Table(name = "sites", schema = "domiot")
public class SiteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  /**
   * Unique name of the site
   */
  String name;
  /**
   * User defined free text
   */
  String description;

  @Temporal(value = TemporalType.TIMESTAMP)
  Date dtCreated;

  /**
   * All users that have access to a location's data, at least one needs to have admin rights
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "siteEntity")
  List<UserEntity> users;

  /**
   * All sensors in this location
   */
  @OneToMany(mappedBy = "siteEntity")
  List<DeviceEntity> deviceEntities;

  /**
   * MqttConfigEntity is site specific. Devices should inherit this config from Site.
   */
  @OneToOne(mappedBy = "siteEntity")
  private MqttConfigEntity mqttConfigEntity;

  public SiteEntity() {
    // required for JPA
  }

  public SiteEntity(String description) {
    this.description = description;
  }


  public long getId() {
    return id;
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

  public Date getDtCreated() {
    return dtCreated;
  }

  public void setDtCreated(Date dtCreated) {
    this.dtCreated = dtCreated;
  }

  public List<UserEntity> getUserList() {
    return users;
  }

  public void setUserList(List<UserEntity> userList) {
    this.users = userList;
  }

  public List<DeviceEntity> getDeviceEntities() {
    return deviceEntities;
  }

  public void setDeviceEntities(List<DeviceEntity> deviceEntities) {
    this.deviceEntities = deviceEntities;
  }

  public MqttConfigEntity getMqttConfigEntity() {
    return mqttConfigEntity;
  }

  public void setMqttConfigEntity(MqttConfigEntity mqttConfigEntity) {
    this.mqttConfigEntity = mqttConfigEntity;
  }
}
