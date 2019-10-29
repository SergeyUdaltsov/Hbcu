package com.hbcu.model.contract.serviceBalance;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.ServiceType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class ServiceBalance {

    @DynamoDBAttribute(attributeName = "pts")
    private List<Payment> payments;

    @DynamoDBAttribute(attributeName = "bal")
    private BigDecimal balance;

    @DynamoDBAttribute(attributeName = "st")
    @DynamoDBTypeConvertedEnum
    private ServiceType serviceType;

    public ServiceBalance() {
        this.payments = new ArrayList<>();
        this.balance = BigDecimal.valueOf(0);
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "ServiceBalance{" +
                "payments=" + payments +
                ", balance=" + balance +
                ", serviceType=" + serviceType +
                '}';
    }
}
