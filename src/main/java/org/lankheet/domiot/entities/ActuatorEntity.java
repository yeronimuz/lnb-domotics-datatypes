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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity that is able to control peripherals at a Location.<BR> Actuator is always regarded separately from a Sensor, even when
 * combined in one case.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
