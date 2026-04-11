package org.lankheet.domiot.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ActiveProfiles("h2")
@ContextConfiguration(classes = {TestDataApplicationConfig.class, SensorValueEntity.class})
class SensorValueEntityTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Test
    void debugDatasource() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            ResultSet rs = conn.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
            assertThat(rs.next()).isTrue();
        }
    }

    @Test
    void testPersist() {
        SensorValueEntity sensorValue = new SensorValueEntity();
        sensorValue.setSensorId(null);
        LocalDateTime now = LocalDateTime.now();
        sensorValue.setTimeStamp(now);
        sensorValue.setValue(3.3);
        SensorValueEntity persisted = entityManager.persist(sensorValue);
        entityManager.flush();

        assertThat(persisted.getId()).isNotNull();

        SensorValueEntity found = entityManager.find(SensorValueEntity.class, sensorValue.getId());
        assertThat(found).isNotNull();
        assertThat(found.getTimeStamp()).isEqualTo(now);
        assertThat(found.getValue()).isEqualTo(3.3);
    }

}
