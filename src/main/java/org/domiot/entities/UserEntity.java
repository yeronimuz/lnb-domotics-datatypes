package org.domiot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.security.Principal;
import java.util.List;

/**
 * User in the domotics service.
 */
@Entity
@Table(name = "users", schema = "domiot")
public class UserEntity implements Principal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String userName;

  @ManyToOne
  private SiteEntity siteEntity;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Permission> permissions;


  public UserEntity() {
    // For JPA
  }


  /**
   * Constructor.
   *
   * @param userName user name
   */
  public UserEntity(String userName, SiteEntity siteEntity) {
    this.userName = userName;
    this.siteEntity = siteEntity;
  }


  /**
   * Get id.
   *
   * @return the id
   */
  public int getId() {
    return this.id;
  }


  /**
   * Get userName.
   *
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }


  /**
   * Set userName.
   *
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }


  /**
   * Get siteId.
   *
   * @return the location
   */
  public SiteEntity getSiteId() {
    return siteEntity;
  }


  /**
   * Set siteId.
   *
   * @param siteEntity the site to set
   */
  public void setSiteId(SiteEntity siteEntity) {
    this.siteEntity = siteEntity;
  }


  /**
   * Get permissions.
   *
   * @return the roles
   */
  public List<Permission> getPermissions() {
    return this.permissions;
  }


  @Override
  public String getName() {
    return getUserName();
  }
}
