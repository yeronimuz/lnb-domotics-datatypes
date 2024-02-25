package org.lankheet.domiot.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * A location represents a domotics site.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sites", schema = "domiot")
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

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dtCreated;

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
