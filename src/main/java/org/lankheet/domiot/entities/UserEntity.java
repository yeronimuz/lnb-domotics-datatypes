package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * User in the domotics service.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "domiot")
public class UserEntity /*implements Principal */ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String userName;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteEntity siteEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "domiot",
            name = "users_permissions"
    )
    private List<PermissionEntity> permissionEntities;

}
