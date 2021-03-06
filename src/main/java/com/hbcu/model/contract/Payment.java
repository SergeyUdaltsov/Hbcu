package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@DynamoDBTable(tableName = "Payments")
public class Payment {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
    private String id;

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "cn-index", attributeName = "cn")
    private String contractNumber;

    @DynamoDBAttribute(attributeName = "d")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long date) {
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

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
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

        @JsonProperty("id")
        public PaymentBuilder withId(String id) {
            this.payment.setId(id);
            return this;
        }

        @JsonProperty("d")
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

//        @JsonProperty("bal")
//        public PaymentBuilder withBalance(BigDecimal sum) {
//            this.payment.setBalance(sum);
//            return this;
//        }

        public Payment build() {
            return this.payment;
        }

    }

    @Override
    public String toString() {
        return "Payment{" +
                "contractNumber='" + contractNumber + '\'' +
                ", date=" + date +
                ", sumBill=" + sumBill +
                ", sumPayment=" + sumPayment +
                ", paymentType=" + paymentType +
                ", serviceType=" + serviceType +
                ", balance=" + balance +
                '}';
    }
}