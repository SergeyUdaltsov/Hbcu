package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Payment
{
    @DynamoDBAttribute(attributeName = "date")
    private long date;
    @DynamoDBAttribute(attributeName = "sum")
    private double sum;
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "pt")
    private PaymentType paymentType;
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "st")
    private ServiceType serviceType;

    public long getDate() {
        return this.date;
    }

    public void setDate(final long date) {
        this.date = date;
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum(final double sum) {
        this.sum = sum;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(final PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}