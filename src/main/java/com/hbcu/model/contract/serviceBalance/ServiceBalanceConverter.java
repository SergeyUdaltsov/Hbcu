package com.hbcu.model.contract.serviceBalance;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.hbcu.model.contract.ServiceType;
import com.hbcu.utils.JsonUtils;

import java.util.List;

public class ServiceBalanceConverter implements DynamoDBTypeConverter<String, List<ServiceBalance>> {

    @Override
    public String convert(List<ServiceBalance> serviceBalances) {
        return JsonUtils.convertObjectToJson(serviceBalances);
    }

    @Override
    public List<ServiceBalance> unconvert(String s) {
        return JsonUtils.parseJson(s, new TypeReference<List<ServiceBalance>>() {
        });
    }
}
