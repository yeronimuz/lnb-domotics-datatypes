package org.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

  @Column(nullable = false, unique = true, length = 45)
  private String userName;

  @Column(name = "email", nullable = false, unique = true, length = 45)
  private String email;

  @Column(nullable = false, length = 64)
  private String password;

  private String firstName;

  private String lastName;

  @ManyToOne
  private SiteEntity siteEntity;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      schema = "domiot",
      name = "users_permissions"
  )
  private List<Permission> permissions;

  public UserEntity() {
    // For JPA
  }


  /**
   * Constructor.
   *
   * @param userName user name
   */
  public UserEntity(String userName, String password, String email, SiteEntity siteEntity) {
    this.userName = userName;
    this.siteEntity = siteEntity;
    this.password = password;
    this.email = email;
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

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public SiteEntity getSiteEntity() {
    return siteEntity;
  }

  public void setSiteEntity(SiteEntity siteEntity) {
    this.siteEntity = siteEntity;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }
}
