package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User role; what may a user do.<BR> A user may have more roles. Each role can be configured for CRUD and control actions.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions", schema = "domiot")
public class PermissionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Name of the role
   */
  @Column(nullable = false, length = 45)
  private String name;

  /**
   * All user permissions OR-ed together
   */
  private int permissionFlags;
}
