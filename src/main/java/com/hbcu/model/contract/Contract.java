package com.hbcu.model.contract;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hbcu.model.contract.serviceBalance.TableBalance;

import java.math.BigDecimal;
import java.util.List;

@DynamoDBDocument
public class Contract {

    @DynamoDBAttribute(attributeName = "cn")
    private String contractName;

    @DynamoDBAttribute(attributeName = "start")
    private long startDate;

    @DynamoDBAttribute(attributeName = "exp")
    private long finDate;

    @DynamoDBAttribute(attributeName = "rent")
    private BigDecimal rent;

    @DynamoDBAttribute(attributeName = "area")
    private BigDecimal area;

    @DynamoDBAttribute(attributeName = "room")
    private String room;

    @DynamoDBAttribute(attributeName = "rt")
    private String roomType;

    private List<TableBalance> tableBalances;

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

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(final String room) {
        this.room = room;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public List<TableBalance> getTableBalances() {
        return tableBalances;
    }

    public void setTableBalances(List<TableBalance> tableBalances) {
        this.tableBalances = tableBalances;
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
        public ContractBuilder withRent(BigDecimal rent) {
            this.contract.setRent(rent);
            return this;
        }

        @JsonProperty("area")
        public ContractBuilder withArea(BigDecimal area) {
            this.contract.setArea(area);
            return this;
        }

        @JsonProperty("room")
        public ContractBuilder withRoom(String room) {
            this.contract.setRoom(room);
            return this;
        }

        @JsonProperty("rt")
        public ContractBuilder withRoomType(String roomType) {
            this.contract.setRoomType(roomType);
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