package com.hbcu.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class CommonUtils {

    private static ObjectMapper mapper;
    private static JsonFactory jsonFactory;

    public static ObjectMapper objectMapper() {
        if (mapper == null) {
            mapper = getObjectMapper();
        }
        return mapper;
    }

    public static JsonFactory getJsonFactory() {
        if (jsonFactory == null) {
            jsonFactory = objectMapper().getFactory();
        }
        return jsonFactory;
    }



    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY, false)
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .registerModule(new JodaModule());
    }


}
