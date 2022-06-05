package com.lankheet.iot.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lankheet.iot.datatypes.entities.Measurement;
import com.lankheet.iot.datatypes.entities.MeasurementType;
import com.lankheet.iot.datatypes.entities.Sensor;
import com.lankheet.iot.datatypes.entities.SensorType;

public class MeasurementTest {
    private static final Logger LOG = LoggerFactory.getLogger(MeasurementTest.class);
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;
    private static final String PERSISTENCE_UNIT = "measurements-pu";
    
    @Before
    public void testSetup() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Test
    public void testMeasurementWithSensor() throws JsonParseException, JsonMappingException, IOException {
        Date now = new Date();
        Sensor sensor = new Sensor(SensorType.POWER_METER, "01:02:03:04", "mainPowerSensor", "meterkast");
        Measurement meas = new Measurement(sensor, now, MeasurementType.CONSUMED_GAS, 2.0);

        entityManager.getTransaction().begin();
        entityManager.persist(sensor);
        entityManager.persist(meas);
        entityManager.getTransaction().commit();

        TypedQuery<Measurement> query = entityManager.createQuery("SELECT m FROM measurements m", Measurement.class);
        List<Measurement> measurements = query.getResultList();
        
        assertThat(measurements.size(), is(1));
        assertThat(measurements.get(0).getMeasurementType(), is(MeasurementType.CONSUMED_GAS));
        Sensor sensorDb = measurements.get(0).getSensor();
        assertThat(sensorDb, is(notNullValue()));
        assertThat(sensorDb.getMacAddress(), is("01:02:03:04"));
    }
    
    @After
    public void doCleanup() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
