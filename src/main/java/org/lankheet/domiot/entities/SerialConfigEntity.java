package org.lankheet.domiot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lankheet.domiot.model.SerialConfig;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "serial_config", schema = "domiot")
public class SerialConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String serialPort;
    private Integer baudRate;

    private String parity;
    private Integer databits;
    private String flowControl;
}
