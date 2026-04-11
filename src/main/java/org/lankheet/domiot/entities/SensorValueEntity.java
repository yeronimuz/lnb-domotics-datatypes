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
@Table(name = "sensor_values", indexes = @Index(columnList = "sensor_id, time_stamp"))
public class SensorValueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @Column(name = "`value`")
    private double value;
}
