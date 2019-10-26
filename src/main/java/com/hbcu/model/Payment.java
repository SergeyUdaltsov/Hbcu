package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class Payment {
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

    public static PaymentBuilder paymentBuilder() {
        return new PaymentBuilder();
    }

    public static class PaymentBuilder {
        private Payment payment;

        public PaymentBuilder() {
            this.payment = new Payment();
        }

        @JsonProperty("date")
        public PaymentBuilder withDate(long date) {
            this.payment.setDate(date);
            return this;
        }

        @JsonProperty("sum")
        public PaymentBuilder withSum(double sum) {
            this.payment.setSum(sum);
            return this;
        }

        @JsonProperty("pt")
        public PaymentBuilder withPaymentType(PaymentType paymentType) {
            this.payment.setPaymentType(paymentType);
            return this;
        }

        @JsonProperty("st")
        public PaymentBuilder withServiceType(ServiceType serviceType) {
            this.payment.setServiceType(serviceType);
            return this;
        }

        public Payment build() {
            return this.payment;
        }

    }
}