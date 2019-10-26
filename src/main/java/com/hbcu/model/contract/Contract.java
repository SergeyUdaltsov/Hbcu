package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hbcu.model.contract.serviceBalance.ServiceBalance;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class Contract {
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

    @JsonProperty
    @DynamoDBAttribute(attributeName = "bal")
    private List<ServiceBalance> serviceBalances;

    public Contract() {
        this.serviceBalances = new ArrayList<>();
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

    public List<ServiceBalance> getServiceBalances() {
        return serviceBalances;
    }

    public void setServiceBalances(List<ServiceBalance> serviceBalances) {
        this.serviceBalances = serviceBalances;
    }

    public static ContractBuilder contractBuilder() {
        return new ContractBuilder();
    }

    public static class ContractBuilder {

        private Contract contract;

        public ContractBuilder() {
            this.contract = new Contract();
        }

        @JsonProperty("n")
        public ContractBuilder withNumber(String number) {
            this.contract.setNumber(number);
            return this;
        }

        @JsonProperty("start")
        public ContractBuilder withStartDate(long startDate) {
            this.contract.setStartDate(startDate);
            return this;
        }

        @JsonProperty("exp")
        public ContractBuilder withFinDate(long finDate) {
            this.contract.setFinDate(finDate);
            return this;
        }

        @JsonProperty("rent")
        public ContractBuilder withRent(double rent) {
            this.contract.setRent(rent);
            return this;
        }

        @JsonProperty("area")
        public ContractBuilder withArea(double area) {
            this.contract.setArea(area);
            return this;
        }

        @JsonProperty("room")
        public ContractBuilder withRoom(String room) {
            this.contract.setRoom(room);
            return this;
        }

        @JsonProperty("bal")
        public ContractBuilder withBalances(List<ServiceBalance> balances) {
            this.contract.setServiceBalances(balances);
            return this;
        }

        public Contract build() {
            return this.contract;
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                "number='" + number + '\'' +
                ", startDate=" + startDate +
                ", finDate=" + finDate +
                ", rent=" + rent +
                ", area=" + area +
                ", room='" + room + '\'' +
                ", serviceBalances=" + serviceBalances +
                '}';
    }
}