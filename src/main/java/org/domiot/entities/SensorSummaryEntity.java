package org.domiot.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "sensor_summaries",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"sensor_id", "period_type_value", "period_start"})
        },
        indexes = {
                @Index(name = "idx_sensor_period", columnList = "sensor_id, period_type_value, period_start")
        }
)
public class SensorSummaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_id")
    private Integer sensorId;

    @Basic
    @Column(name = "period_type_value")
    private int periodTypeValue;

    @Transient
    private PeriodType periodType;

    @Column(name = "period_start", nullable = false)
    private LocalDateTime periodStart;

    private Double minValue;

    private Double maxValue;

    private Double avgValue;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] timeSeriesData;

    @PostLoad
    void fillTransient() {
        if (periodTypeValue > 0) {
            this.periodType = PeriodType.getType(periodTypeValue);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (periodType != null) {
            this.periodTypeValue = periodType.getId();
        }
    }
}
