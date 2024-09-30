package org.lankheet.domiot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * A SensorValue is a single information item that is produced by the LNB domotics system.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sensor_values", schema = "domiot", indexes = @Index(columnList = "sensorEntity, timeStamp"))
public class SensorValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private Long sensorId;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime timeStamp;

    private double value;
}
