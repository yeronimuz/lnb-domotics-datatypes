/**
 * MIT License
 * 
 * Copyright (c) 2017 Lankheet Software and System Solutions
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lankheet.iot.datatypes;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * Sensor types.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = SensorType.SensorTypeDeserializer.class)
public enum SensorType {
    TEMPERATURE(1, "temperature"),
    HUMIDITY(2, "humidity"),
    POWER_METER(3, "power_meter"),
    GAS_METER(4, "gas_meter"),
    GAS_SENSOR(5, "gas_sensor");

    private int id;

    private String description;

    private SensorType(int id, String name) {
        this.id = id;
        this.description = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Get type by Id.
     * 
     * @param type The type.id to lookup.
     * @return The SensorType that matches the type.id or null if not found
     */
    @JsonValue
    public static SensorType getType(Integer type) {
        SensorType returnType = null;
        for (SensorType sensorType : SensorType.values()) {
            if (type == sensorType.getId()) {
                returnType = sensorType;
                break;
            }
        }
        return returnType;
    }

    public static class SensorTypeDeserializer extends StdDeserializer<SensorType> {

        private static final long serialVersionUID = 1L;

        protected SensorTypeDeserializer() {
            super(SensorType.class);
        }
        
        @Override
        public SensorType deserialize(JsonParser jasonParser, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {
            final JsonNode jsonNode = jasonParser.readValueAsTree();
            String id = jsonNode.get("id").asText();
            String name = jsonNode.get("description").asText();

            for (SensorType sensorType : SensorType.values()) {
                if (sensorType.getId().equals(id) && sensorType.getDescription().equals(name)) {
                    return sensorType;
                }
            }
            throw deserializationContext
                    .mappingException("Cannot deserialize SensorType from id " + id + " and description " + name);
        }
    }
}
