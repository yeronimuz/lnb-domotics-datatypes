package org.lankheet.domiot.entities;

import java.util.stream.Stream;

public enum PeriodType {
    CURRENT(0),
    HOURLY(1),
    DAILY(2),
    WEEKLY(3),
    MONTHLY(4),
    YEARLY(5);

    private final int id;

    PeriodType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Get type by Id.
     *
     * @param type The type.id to lookup.
     * @return The PeriodType that matches the type.id or null if not found
     */
    public static PeriodType getType(int type) {
        return Stream.of(PeriodType.values())
                .filter(value -> value.id == type)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
