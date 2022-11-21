package com.lankheet.iot.datatypes.entities;

import com.lankheet.iot.crypto.CryptoConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.security.Principal;
import java.util.List;

/**
 * User in the domotics service.
 */
@Entity(name = "users")
public class DomoticsUser implements Principal
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String userName;

   @Convert(converter = CryptoConverter.class)
   private String password;

   @OneToOne
   private Site site;

   @OneToMany
   private List<Permission> permissions;


   public DomoticsUser()
   {
      // For JPA
   }


   /**
    * Constructor.
    *
    * @param userName user name
    * @param passWord password, hashed
    */
   public DomoticsUser(String userName, String passWord, Site site)
   {
      this.userName = userName;
      this.password = passWord;
      this.site = site;
   }


   /**
    * Get id.
    *
    * @return the id
    */
   public int getId()
   {
      return this.id;
   }


   /**
    * Get userName.
    *
    * @return the userName
    */
   public String getUserName()
   {
      return userName;
   }


   /**
    * Set userName.
    *
    * @param userName the userName to set
    */
   public void setUserName(String userName)
   {
      this.userName = userName;
   }


   /**
    * Get password.
    *
    * @return the password
    */
   public String getPassword()
   {
      return password;
   }


   /**
    * Set password.
    *
    * @param password the password to set
    */
   public void setPassword(String password)
   {
      this.password = password;
   }


   /**
    * Get siteId.
    *
    * @return the location
    */
   public Site getSiteId()
   {
      return site;
   }


   /**
    * Set siteId.
    *
    * @param site the site to set
    */
   public void setSiteId(Site site)
   {
      this.site = site;
   }


   /**
    * Get permissions.
    *
    * @return the roles
    */
   public List<Permission> getPermissions()
   {
      return this.permissions;
   }


   @Override
   public String getName()
   {
      return getUserName();
   }
}
