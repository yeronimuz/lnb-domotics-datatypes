package org.lankheet.domiot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
