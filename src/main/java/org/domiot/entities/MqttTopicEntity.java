package org.domiot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mqtt_topics", schema = "domiot")
public class MqttTopicEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**
   * #siteId/floor/room/device/sensor|actutor/sensor|actuatorId
   */
  private String path;

  @ManyToOne
  private MqttConfigEntity mqttConfigEntity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public MqttConfigEntity getMqttConfigEntity() {
    return mqttConfigEntity;
  }

  public void setMqttConfigEntity(MqttConfigEntity mqttConfigEntity) {
    this.mqttConfigEntity = mqttConfigEntity;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
