package org.lankheet.domiot.domotics.datatypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lankheet.domiot.model.Sensor;

import java.util.Date;
import java.util.Objects;

/**
 * A sensor's measured value. It is the object that will be serialized and sent to the backend via
 * an MQTT broker and will be handled by the backend.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorValue {
    private Sensor sensor;

    private Date timeStamp;

    private int measurementType;

    private double value;
}
