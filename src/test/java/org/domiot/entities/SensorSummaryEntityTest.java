package org.domiot.entities;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ActiveProfiles("h2") // or "mariadb"
@ContextConfiguration(classes = TestDataApplicationConfig.class)
class SensorSummaryEntityTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testPersist() {
        var summary = new SensorSummaryEntity();
        summary.setSensorId(1);
        summary.setPeriodType(PeriodType.HOURLY);
        LocalDateTime now = LocalDateTime.now();
        summary.setPeriodStart(now);
        SensorSummaryEntity persisted = entityManager.persist(summary);
        entityManager.flush();

        SensorSummaryEntity found = entityManager.find(SensorSummaryEntity.class, persisted.getId());
        assertThat(found).isNotNull();
        assertThat(found.getPeriodType()).isEqualTo(PeriodType.HOURLY);
        assertThat(found.getPeriodStart()).isEqualTo(now);
    }
}
