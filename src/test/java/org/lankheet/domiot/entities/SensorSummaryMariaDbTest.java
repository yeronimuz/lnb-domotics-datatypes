package org.lankheet.domiot.entities;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@ActiveProfiles("mariadb")
@ContextConfiguration(classes = TestDataApplicationConfig.class)
class SensorSummaryMariaDbTest {

    @Container
    static MariaDBContainer<?> mariaDB = new MariaDBContainer<>("mariadb:10.6")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass")
            .withReuse(true); // Optional: speeds up repeated runs

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariaDB::getJdbcUrl);
        registry.add("spring.datasource.username", mariaDB::getUsername);
        registry.add("spring.datasource.password", mariaDB::getPassword);
        registry.add("spring.datasource.driver-class-name", mariaDB::getDriverClassName);
    }

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testPersistMariaDB() {
        SensorSummaryEntity summary = new SensorSummaryEntity();
        summary.setSensorId(99);
        summary.setPeriodType(PeriodType.HOURLY);
        summary.setPeriodStart(LocalDateTime.now());
        entityManager.persist(summary);
        entityManager.flush();

        SensorSummaryEntity found = entityManager.find(SensorSummaryEntity.class, summary.getId());
        assertThat(found).isNotNull();
    }
}
