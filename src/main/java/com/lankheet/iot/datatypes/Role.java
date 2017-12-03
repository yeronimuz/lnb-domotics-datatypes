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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User role; what may a user do.<BR>
 * A user may have more roles. Each role can be configured for CRUD and control actions.
 */
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Name of the role */
    private String name;

    /** A user may or may not read */
    private boolean read;

    /** A user may or may not write (add other user) */
    private boolean write;

    /** A user may or may not delete */
    private boolean delete;

    /** A user may or may not modify Location's settings */
    private boolean modify;

    /** A user may or may not control actuators */
    private boolean control;

    public Role() {
        // For JPA
    }

    /**
     * Constructor.
     * 
     * @param name The name of the role
     * @param read Reading permissions on measurements, sensors and location
     * @param write Writing permissions on measurements, sensors and location
     * @param delete permissions on measurements, sensors and location
     * @param modify permissions to modify sensors, location
     * @param control Permission to control actuators, create switching patterns
     */
    public Role(String name, boolean read, boolean write, boolean delete, boolean modify, boolean control) {
        super();
        this.name = name;
        this.read = read;
        this.write = write;
        this.delete = delete;
        this.modify = modify;
        this.control = control;
    }

    /**
     * Get name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get read.
     * @return the read
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Set read.
     * @param read the read to set
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * Get write.
     * @return the write
     */
    public boolean isWrite() {
        return write;
    }

    /**
     * Set write.
     * @param write the write to set
     */
    public void setWrite(boolean write) {
        this.write = write;
    }

    /**
     * Get delete.
     * @return the delete
     */
    public boolean isDelete() {
        return delete;
    }

    /**
     * Set delete.
     * @param delete the delete to set
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    /**
     * Get modify.
     * @return the modify
     */
    public boolean isModify() {
        return modify;
    }

    /**
     * Set modify.
     * @param modify the modify to set
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * Get control.
     * @return the control
     */
    public boolean isControl() {
        return control;
    }

    /**
     * Set control.
     * @param control the control to set
     */
    public void setControl(boolean control) {
        this.control = control;
    }

    /**
     * Get id.
     * @return the id
     */
    public int getId() {
        return id;
    }
}
