package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class Payment {
    @DynamoDBAttribute(attributeName = "date")
    private long date;

    @DynamoDBAttribute(attributeName = "sumBill")
    private double sumBill;

    @DynamoDBAttribute(attributeName = "sumPay")
    private double sumPayment;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "pt")
    private PaymentType paymentType;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "st")
    private ServiceType serviceType;

    @DynamoDBAttribute(attributeName = "bal")
    private double balance;

    public long getDate() {
        return this.date;
    }

    public void setDate(final long date) {
        this.date = date;
    }

    public double getSumBill() {
        return sumBill;
    }

    public void setSumBill(double sumBill) {
        this.sumBill = sumBill;
    }

    public double getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(double sumPayment) {
        this.sumPayment = sumPayment;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

        @JsonProperty("sumBill")
        public PaymentBuilder withSumBill(double sum) {
            this.payment.setSumBill(sum);
            return this;
        }

        @JsonProperty("sumPay")
        public PaymentBuilder withSumPayment(double sum) {
            this.payment.setSumPayment(sum);
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

        @JsonProperty("bal")
        public PaymentBuilder withBalance(double sum) {
            this.payment.setBalance(sum);
            return this;
        }

        public Payment build() {
            return this.payment;
        }

    }
}