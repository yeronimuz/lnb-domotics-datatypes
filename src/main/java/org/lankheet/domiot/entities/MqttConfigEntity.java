package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
