package org.lankheet.domiot.domotics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Device DTO for the MQTT domain
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String manufacturerId;
    private String modelId;
    private String firmwareVersion;
    private String hardwareVersion;
    private String macAddress;

    private List<DomiotParameterDto> parameters;
    private List<SensorDto> sensors;
    private List<ActuatorDto> actuators;

    public DeviceDto addSensor(SensorDto sensor) {
        if (sensors == null) {
            sensors = new ArrayList<>();
        }
        sensors.add(sensor);
        return this;
    }

    public DeviceDto addActuator(ActuatorDto actuator) {
        if (actuators == null) {
            actuators = new ArrayList<>();
        }
        actuators.add(actuator);
        return this;
    }

    public DeviceDto addParameter(DomiotParameterDto parameter) {
        if (parameters == null) {
            parameters = new ArrayList<>();
        }
        parameters.add(parameter);
        return this;
    }
}
