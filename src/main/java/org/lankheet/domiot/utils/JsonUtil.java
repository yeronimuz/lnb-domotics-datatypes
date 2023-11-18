package org.lankheet.domiot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import org.lankheet.domiot.domotics.datatypes.SensorValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

  private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

  private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
      .configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

  public static String toJson(Object o) {
    try {
      return mapper.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      logger.error("Json Processing was wrong: {}", e.getMessage());
    }

    return null;
  }

  public static SensorValue fromJson(String json) throws IOException {
    return mapper.readValue(json, SensorValue.class);
  }
}
