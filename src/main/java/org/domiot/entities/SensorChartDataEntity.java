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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "sensor_chart_data",
        indexes = {
                @Index(name = "idx_sensor_period_start", columnList = "sensor_id, period_type_value, period_start")
        }
)
public class SensorChartDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sensor_id")
    private Integer sensorId;

    private Double minValue;

    private Double maxValue;

    @Basic
    @Column(name = "period_type_value")
    private int periodTypeValue;

    @Transient
    private PeriodType periodType;

    @Column(name = "period_start")
    private LocalDateTime periodStart;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] alignedChartData; // e.g., MessagePack or JSON

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
