package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "domiot_parameters", schema = "domiot")
public class DomiotParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String parameterType;

    @Column(name = "value", columnDefinition = "varchar(255)")
    private Object value;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceEntity deviceEntity;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private SensorEntity sensorEntity;

    @ManyToOne
    @JoinColumn(name = "actuator_id")
    private ActuatorEntity actuatorEntity;
}
