package com.lankheet.iot.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import java.util.Date;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lankheet.utils.JsonUtil;

public class MeasurementTest {
    private static final Logger LOG = LoggerFactory.getLogger(MeasurementTest.class);

    @Test
    public void test() throws JsonParseException, JsonMappingException, IOException {
        Date now = new Date();
        Measurement meas = new Measurement(1, now, MeasurementType.CONSUMED_GAS.getId(), 2.0);
        String jsonMeasurement = JsonUtil.toJson(meas);
        LOG.info(jsonMeasurement);

        Measurement measBack = JsonUtil.measurementFromJson(jsonMeasurement);
        assertThat(measBack.getType(), is(MeasurementType.CONSUMED_GAS.getId()));
        assertThat(measBack.getTimeStamp().compareTo(now), is(0));
        assertThat(measBack.getValue(), is(2.0));
    }
}
