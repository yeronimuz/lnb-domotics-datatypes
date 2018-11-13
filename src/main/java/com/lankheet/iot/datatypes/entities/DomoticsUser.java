package com.lankheet.iot.datatypes.entities;

import java.security.Principal;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.lankheet.iot.crypto.CryptoConverter;

/**
 * User in the domotics service.
 */
@Entity(name = "users")
public class DomoticsUser implements Principal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String userName;
    
    @Convert(converter = CryptoConverter.class)
    private String password;
    
    @ManyToMany
    private List<Location> locations;
    
    @OneToMany
    private List<DomoticsRole> roles;
    
    public DomoticsUser() {
        // For JPA
    }
    
    /**
     * Constructor.
     * @param userName user name
     * @param passWord password, hashed
     */
    public DomoticsUser(String userName, String passWord) {
        this.userName = userName;
        this.password = passWord;
    }

    /**
     * Get id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get userName.
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName.
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get location.
     * @return the location
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Set location.
     * @param location the location to set
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Get roles.
     * @return the roles
     */
    public List<DomoticsRole> getRoles() {
        return roles;
    }

    /**
     * Set roles.
     * @param roles the roles to set
     */
    public void setRoles(List<DomoticsRole> roles) {
        this.roles = roles;
    }

    @Override
    public String getName() {
        return getUserName();
    }
}
