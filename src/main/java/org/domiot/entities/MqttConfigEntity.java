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
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "mqtt_config", schema = "domiot")
public class MqttConfigEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private int id;

  private BigDecimal clientId;
  private BigDecimal userId;
  private String url;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "mqttConfigEntity")
  private List<MqttTopicEntity> mqttTopicEntities = new java.util.ArrayList<>();

  @OneToOne
  private SiteEntity siteEntity;

  public MqttConfigEntity() {
    // For JPA
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public BigDecimal getClientId() {
    return clientId;
  }

  public void setClientId(BigDecimal clientId) {
    this.clientId = clientId;
  }

  public BigDecimal getUserId() {
    return userId;
  }

  public void setUserId(BigDecimal userId) {
    this.userId = userId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<MqttTopicEntity> getTopicEntities() {
    return mqttTopicEntities;
  }

  public void setMqttTopicEntities(List<MqttTopicEntity> mqttTopicEntities) {
    this.mqttTopicEntities = mqttTopicEntities;
  }
}
