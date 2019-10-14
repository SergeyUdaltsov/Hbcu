package com.hbcu.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.hbcu.utils.JsonUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Map;

public abstract class AbstractLambdaHandler<REQ, RES> implements RequestStreamHandler {

    private TypeReference<REQ> requestType;

    public AbstractLambdaHandler(Class<REQ> requestType) {
        this.requestType = new TypeReference<REQ>() {
            @Override
            public Type getType() {
                return requestType;
            }
        };
    }

    public AbstractLambdaHandler() {
    }

    public void handleRequest(InputStream input, OutputStream outputStream, Context context) throws IOException {
        Map<String, Object> rawRequest = JsonUtils.parseStream(input, new TypeReference<Map<String, Object>>() {
        });
        System.out.println("Raw Request: " + rawRequest);

        REQ request = JsonUtils.parseMap(rawRequest, requestType);
        System.out.println("Request ----- " + JsonUtils.convertObjectToJson(request));

        RES response = process(request);
        System.out.println("Response ----- " + JsonUtils.convertObjectToJson(response));

        JsonUtils.writeObjectToOutput(outputStream, response);

    }

    protected abstract RES process(REQ request);
}
