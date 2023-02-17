package org.domiot.domotics.datatypes;

/**
 * A SensorNode is the origin of a measurement in the Domiotics domain.<BR>
 *
 * <ul>The sensor exists in 3 models in a different context:</ul>
 * <li>This sensor (node) lives on the mqtt line</li>
 * <li>The SensorEntity is the database thingie</li>
 * <li>The openapi defines a Sensor as the object that is communicated between back- and frontend</li>
 * <BR>
 * A device may consist of several sensors and/or actuators. Each sensor may only deliver a measurement of one type.
 */
public class SensorNode {

  private String sensorMac;

  private int sensorType;

  public SensorNode() {
    // For Jaxon
  }

  /**
   * Constructor.
   *
   * @param sensorMac  The sensor id
   * @param sensorType The type of sensor (SensorType)
   */
  public SensorNode(String sensorMac, int sensorType) {
    this.sensorMac = sensorMac;
    this.sensorType = sensorType;
  }

  /**
   * Get the type.
   *
   * @return The type of the sensor (enum)
   */
  public int getSensorType() {
    return sensorType;
  }

  /**
   * Get sensorMAC.
   *
   * @return the sensorMAC address
   */
  public String getSensorMac() {
    return sensorMac;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SensorNode [sensorMac=" + sensorMac + ", sensorType=" + sensorType + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((sensorMac == null) ? 0 : sensorMac.hashCode());
    result = prime * result + sensorType;
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null) {
          return false;
      }
      if (getClass() != obj.getClass()) {
          return false;
      }
    SensorNode other = (SensorNode) obj;
    if (sensorMac == null) {
        if (other.sensorMac != null) {
            return false;
        }
    } else if (!sensorMac.equals(other.sensorMac)) {
        return false;
    }
    return sensorType == other.sensorType;
  }
}
