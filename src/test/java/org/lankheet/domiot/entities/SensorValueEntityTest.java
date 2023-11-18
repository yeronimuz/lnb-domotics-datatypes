package org.lankheet.domiot.entities;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public class SensorValueEntityTest {
  static final Logger LOG = LoggerFactory.getLogger(SensorValueEntityTest.class);
  static EntityManagerFactory entityManagerFactory;

  static EntityManager entityManager;
  static final String PERSISTENCE_UNIT = "domiot";

  @BeforeAll
  public static void testSetup() {
    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    entityManager = entityManagerFactory.createEntityManager();
  }

  @AfterAll
  public static void doCleanup() {
    entityManager.close();
    entityManagerFactory.close();
  }

  @Test
  void testMeasurementWithSensor() {
    Date now = new Date();
    SensorEntity sensorEntity = new SensorEntity(SensorType.POWER_AP, "mainPowerSensor", "meterkast");
    SensorValueEntity sensorValueEntity = new SensorValueEntity(sensorEntity, now, MeasurementType.CONSUMED_GAS, 2.0);

    entityManager.getTransaction().begin();
    entityManager.persist(sensorEntity);
    entityManager.persist(sensorValueEntity);
    entityManager.getTransaction().commit();

    TypedQuery<SensorValueEntity> query = entityManager.createQuery("SELECT s FROM SensorValueEntity s",
        SensorValueEntity.class);
    List<SensorValueEntity> sensorValuesReturned = query.getResultList();

    assertThat(sensorValuesReturned.size(), is(1));
    assertThat(sensorValuesReturned.get(0).getMeasurementType(), CoreMatchers.is(MeasurementType.CONSUMED_GAS));
    SensorEntity sensorEntityDb = sensorValuesReturned.get(0).getSensor();
    assertThat(sensorEntityDb, is(notNullValue()));
  }
}
