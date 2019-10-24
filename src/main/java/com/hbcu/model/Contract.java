package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class Contract
{
    @JsonProperty
    @DynamoDBAttribute(attributeName = "n")
    private String number;
    @JsonProperty
    @DynamoDBAttribute(attributeName = "start")
    private long startDate;
    @JsonProperty
    @DynamoDBAttribute(attributeName = "exp")
    private long finDate;
    @JsonProperty
    @DynamoDBAttribute(attributeName = "rent")
    private double rent;
    @JsonProperty
    @DynamoDBAttribute(attributeName = "area")
    private double area;
    @JsonProperty
    @DynamoDBAttribute(attributeName = "room")
    private String room;
    @DynamoDBAttribute(attributeName = "rb")
    private double rentBalance;
    @DynamoDBAttribute(attributeName = "pb")
    private double powBalance;
    @DynamoDBAttribute(attributeName = "eb")
    private double expBalance;
    @DynamoDBAttribute(attributeName = "pts")
    private List<Payment> payments;

    public Contract() {
        this.payments = new ArrayList<Payment>();
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public long getStartDate() {
        return this.startDate;
    }

    public void setStartDate(final long startDate) {
        this.startDate = startDate;
    }

    public long getFinDate() {
        return this.finDate;
    }

    public void setFinDate(final long finDate) {
        this.finDate = finDate;
    }

    public double getRent() {
        return this.rent;
    }

    public void setRent(final double rent) {
        this.rent = rent;
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(final double area) {
        this.area = area;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(final String room) {
        this.room = room;
    }

    public double getRentBalance() {
        return this.rentBalance;
    }

    public void setRentBalance(final double rentBalance) {
        this.rentBalance = rentBalance;
    }

    public double getPowBalance() {
        return this.powBalance;
    }

    public void setPowBalance(final double powBalance) {
        this.powBalance = powBalance;
    }

    public double getExpBalance() {
        return this.expBalance;
    }

    public void setExpBalance(final double expBalance) {
        this.expBalance = expBalance;
    }

    public List<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(final List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Contract{number='" + this.number + '\'' + ", startDate=" + this.startDate + ", finDate=" + this.finDate + ", rent=" + this.rent + ", area=" + this.area + ", room='" + this.room + '\'' + '}';
    }
}