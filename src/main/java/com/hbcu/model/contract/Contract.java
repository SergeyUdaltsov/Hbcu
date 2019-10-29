package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class Contract {

    @DynamoDBAttribute(attributeName = "cn")
    private String contractName;

    @DynamoDBAttribute(attributeName = "start")
    private long startDate;

    @DynamoDBAttribute(attributeName = "exp")
    private long finDate;

    @DynamoDBAttribute(attributeName = "rent")
    private double rent;

    @JsonProperty
    @DynamoDBAttribute(attributeName = "area")
    private double area;

    @DynamoDBAttribute(attributeName = "room")
    private String room;

    public Contract() {
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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

    public static ContractBuilder contractBuilder() {
        return new ContractBuilder();
    }

    public static class ContractBuilder {

        private Contract contract;

        public ContractBuilder() {
            this.contract = new Contract();
        }

        @JsonProperty("cn")
        public ContractBuilder withName(String name) {
            this.contract.setContractName(name);
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

        public Contract build() {
            return this.contract;
        }
    }

    @Override
    public String toString() {
        return "Contract{" +
                ", contractName='" + contractName + '\'' +
                ", startDate=" + startDate +
                ", finDate=" + finDate +
                ", rent=" + rent +
                ", area=" + area +
                ", room='" + room + '\'' +
                '}';
    }
}