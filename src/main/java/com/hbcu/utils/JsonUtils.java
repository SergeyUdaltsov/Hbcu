//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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
    public JsonUtils() {
    }

    public static <T> T parseStream(InputStream input, TypeReference<T> typeReference) {
        try {
            return CommonUtils.objectMapper().readValue(input, typeReference);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("Error while parsing stream.");
        }
    }

    public static <T> T parseJson(InputStream input, Class<T> clazz) {
        try {
            JsonParser parser = CommonUtils.getJsonFactory().createParser(input);
            parser.nextToken();
            return parser.readValueAs(clazz);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("Error while parsing stream.");
        }
    }

    public static <T> T parseJson(String json, TypeReference<T> typeReference) {
        try {
            return CommonUtils.objectMapper().readValue(json, typeReference);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(String.format("Error while parsing json: %s", json));
        }
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return CommonUtils.objectMapper().readValue(json, clazz);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException(String.format("Error while parsing json: %s", json));
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
            generator.writeObject(object);
        } catch (IOException var3) {
            var3.printStackTrace();
            throw new RuntimeException("Error while writing object to response.");
        }
    }

    public static String convertObjectToJson(Object data) {
        return convertObjectToJson(data, true);
    }

    public static String convertObjectToJson(Object data, boolean isPretty) {
        try {
            return isPretty ? CommonUtils.objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(data) : CommonUtils.objectMapper().writer().writeValueAsString(data);
        } catch (JsonProcessingException var3) {
            throw new RuntimeException("Exception in converting object to json:" + var3.getMessage(), var3);
        }
    }
}
