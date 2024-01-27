package org.lankheet.domiot.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * A sensor is the origin of a measurement
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
  @JoinColumn(name = "device_id")
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

}
