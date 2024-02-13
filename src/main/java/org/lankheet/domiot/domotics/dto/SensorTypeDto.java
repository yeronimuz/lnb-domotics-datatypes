package org.lankheet.domiot.domotics.dto;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum SensorTypeDto {
    NOT_USED(0, "NOT_USED"),
    POWER_PT1(1, "POWER_PT1"),
    POWER_PT2(2, "POWER_PT2"),
    POWER_CT1(3, "POWER_CT1"),
    POWER_CT2(4, "POWER_CT2"),
    POWER_AP(5, "POWER_AP"),
    POWER_AC(6, "POWER_AC"),
    GAS_METER(7, "GAS_METER"),
    TEMP(8, "TEMP"),
    HUMID(9, "HUMID"),
    WATER(10, "WATER_CONSUMED"),
    GAS_SENSOR(11, "GAS_SENSOR"),
    HYDRO(12, "HYDRATION"),
    STATUS(13, "STATUS"),
    VOLTAGE_LEVEL(14, "VOLTAGE_LEVEL"),
    CURRENT_LEVEL(15, "VOLTAGE_LEVEL");

    private final int id;

    private final String description;

    SensorTypeDto(int id, String name) {
        this.id = id;
        this.description = name;
    }

    /**
     * Get type by Id.
     *
     * @param type The type.id to lookup.
     * @return The SensorType that matches the type.id or null if not found
     */
    public static SensorTypeDto getType(int type) {
        return Stream.of(SensorTypeDto.values())
                .filter(value -> value.id == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
