package org.lankheet.domiot.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "devices", schema = "domiot")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String manufacturerId;
    private String modelId;
    private String firmwareVersion;
    private String hardwareVersion;

    @Column(unique = true)
    private String macAddress;

    @OneToOne
    private MqttConfigEntity mqttConfig;
    @OneToOne
    private SerialConfigEntity serialConfig;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "deviceEntity")
    private List<DomiotParameterEntity> parameters;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "deviceEntity")
    private List<SensorEntity> sensors;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "deviceEntity")
    private List<ActuatorEntity> actuators;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteEntity siteEntity;
}
