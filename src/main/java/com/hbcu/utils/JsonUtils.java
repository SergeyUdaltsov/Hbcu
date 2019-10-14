package com.hbcu.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class JsonUtils {

    public static <T> T parseStream(InputStream input, TypeReference<T> typeReference) {
        try {
            return CommonUtils.objectMapper().readValue(input, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while parsing stream.");
        }
    }

    public static <T> T parseJson(InputStream input, Class<T> clazz) {
        try {
            JsonParser parser = CommonUtils.getJsonFactory().createParser(input);
            parser.nextToken();
            return parser.readValueAs(clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while parsing stream.");
        }
    }

    public static <T> T parseMap(Map<String, ?> params, Class<T> clazz) {
        return CommonUtils.objectMapper().convertValue(params, clazz);
    }

    public static <T> T parseMap(Map<String, ?> params, TypeReference<T> typeReference) {
        return CommonUtils.objectMapper().convertValue(params, typeReference);
    }

    public static <T> void writeObjectToOutput(OutputStream out, T object) {
        try {
            JsonGenerator generator = CommonUtils.getJsonFactory().createGenerator(out);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while writing object to response.");
        }
    }

    public static String convertObjectToJson(Object data) {
        return convertObjectToJson(data, true);
    }

    public static String convertObjectToJson(Object data, boolean isPretty) {
        try {
            if (isPretty) {
                return CommonUtils.objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(data);
            } else {
                return CommonUtils.objectMapper().writer().writeValueAsString(data);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Exception in converting object to json:" + e.getMessage(), e);
        }
    }
}
