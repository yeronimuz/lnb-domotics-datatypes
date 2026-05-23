package org.domiot.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.mapstruct.Named;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.springframework.stereotype.Component;

@Component
public class TimeSeriesMapper {

    private final ObjectMapper objectMapper;

    public TimeSeriesMapper() {
        this.objectMapper = new ObjectMapper(new MessagePackFactory());
    }

    @Named("toList")
    public List<Double> toList(byte[] data) {
        if (data == null) return new ArrayList<>();
        try {
            return objectMapper.readValue(data, objectMapper.getTypeFactory().constructCollectionType(List.class, Double.class));
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize time series", e);
        }
    }

    @Named("toBytes")
    public byte[] toBytes(List<Double> list) {
        if (list == null) return new byte[0];
        try {
            return objectMapper.writeValueAsBytes(list);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize time series", e);
        }
    }
}
