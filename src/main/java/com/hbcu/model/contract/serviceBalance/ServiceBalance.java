package com.hbcu.model.contract.serviceBalance;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.ServiceType;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class ServiceBalance {

    @DynamoDBAttribute(attributeName = "pts")
    private List<Payment> payments;

    @DynamoDBAttribute(attributeName = "bal")
    private double balance;

    public ServiceBalance() {
        this.payments = new ArrayList<>();
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "ServiceBalance{" +
                ", payments=" + payments +
                '}';
    }
}
