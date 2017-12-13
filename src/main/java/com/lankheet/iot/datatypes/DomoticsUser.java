/**
 * MIT License
 * 
 * Copyright (c) 2017 Lankheet Software and System Solutions
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lankheet.iot.datatypes;

import java.security.Principal;
import java.util.List;
import javax.management.relation.Role;
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
@Entity
public class DomoticsUser implements Principal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String userName;
    
    @Convert(converter = CryptoConverter.class)
    private String password;
    
    @ManyToMany(mappedBy="id")
    private List<Location> location;
    
    @OneToMany(mappedBy = "id")
    private List<Role> roles;
    
    public DomoticsUser() {
        // For JPA
    }
    
    public DomoticsUser(String userName, String passWord) {
        this.userName = userName;
        this.password = passWord;
        // TODO: Location
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
    public List<Location> getLocation() {
        return location;
    }

    /**
     * Set location.
     * @param location the location to set
     */
    public void setLocation(List<Location> location) {
        this.location = location;
    }

    /**
     * Get roles.
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * Set roles.
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getName() {
        return getUserName();
    }
}
