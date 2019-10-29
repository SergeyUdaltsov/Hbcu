package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@DynamoDBTable(tableName = "Payments")
public class Payment {

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "cn")
    private String contractNumber;

    @DynamoDBAttribute(attributeName = "date")
    private long date;

    @DynamoDBAttribute(attributeName = "sumBill")
    private BigDecimal sumBill;

    @DynamoDBAttribute(attributeName = "sumPay")
    private BigDecimal sumPayment;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "pt")
    private PaymentType paymentType;

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute(attributeName = "st")
    private ServiceType serviceType;

    private BigDecimal balance;

    public Payment() {
        this.sumBill = new BigDecimal(0);
        this.sumPayment = new BigDecimal(0);
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(final long date) {
        this.date = date;
    }

    public BigDecimal getSumBill() {
        return sumBill;
    }

    public void setSumBill(BigDecimal sumBill) {
        this.sumBill = sumBill;
    }

    public BigDecimal getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(BigDecimal sumPayment) {
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
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

        @JsonProperty("cn")
        public PaymentBuilder withContractNumber(String contractNumber) {
            this.payment.setContractNumber(contractNumber);
            return this;
        }

        @JsonProperty("date")
        public PaymentBuilder withDate(long date) {
            this.payment.setDate(date);
            return this;
        }

        @JsonProperty("sumBill")
        public PaymentBuilder withSumBill(BigDecimal sum) {
            this.payment.setSumBill(sum);
            return this;
        }

        @JsonProperty("sumPay")
        public PaymentBuilder withSumPayment(BigDecimal sum) {
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
        public PaymentBuilder withBalance(BigDecimal sum) {
            this.payment.setBalance(sum);
            return this;
        }

        public Payment build() {
            return this.payment;
        }

    }
}