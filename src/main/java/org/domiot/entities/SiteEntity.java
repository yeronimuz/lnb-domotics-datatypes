package org.domiot.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A location represents a domotics site.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sites")
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Unique name of the site
     */
    private String name;
    /**
     * User defined free text
     */
    private String description;

    private LocalDateTime dtCreated;

    /**
     * All users that have access to a location's data, at least one needs to have admin rights
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "siteEntity")
    private List<UserEntity> users;

    /**
     * All sensors in this location
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "siteEntity")
    private List<DeviceEntity> deviceEntities;

    /**
     * MqttConfigEntity is site specific. Devices should inherit this config from Site.
     */
    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "siteEntity")
    private MqttConfigEntity mqttConfigEntity;

}
