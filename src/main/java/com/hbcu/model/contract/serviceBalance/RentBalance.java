package com.hbcu.model.contract.serviceBalance;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.hbcu.model.contract.ServiceType;

public class RentBalance extends ServiceBalance {

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "st")
    private ServiceType serviceType;

    public RentBalance() {
        super(ServiceType.RENT);
    }
}
