package com.essai.testautomation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.restassured.response.Response;

public class ObjectJsonMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.registerModule(new JavaTimeModule());
    }

    public static <T> T deserializeJson(Response response, Class<T> type) {
        if (response != null) {
            return deserializeJson(response.getBody().print(), type);

        } else {
            return null;
        }
    }

    public static <T> T deserializeJson(Object json, Class<T> type) {
        if (json == null) {
            return null;
        }
        try {
            return MAPPER.readValue(json.toString(), type);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error during JSON serialization", e);
        }
    }

    public static String serializeJson(Object o) {
        if (o == null) {
            return null;
        }
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error during JSON deserialization", e);
        }
    }
}
