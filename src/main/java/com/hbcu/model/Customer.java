package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@DynamoDBTable(tableName = "Customers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @DynamoDBAttribute(attributeName = "cn")
    private String companyName;

    @DynamoDBAttribute(attributeName = "email")
    @DynamoDBHashKey
    private String email;

    @DynamoDBAttribute(attributeName = "c")
    private String contract;

    @DynamoDBAttribute(attributeName = "r")
    private String room;

    @DynamoDBAttribute(attributeName = "a")
    private double area;

    @DynamoDBAttribute(attributeName = "re")
    private double rent;

    @DynamoDBAttribute(attributeName = "cexp")
    private long contractExpiration;

    @DynamoDBAttribute(attributeName = "cont")
    private String contacts;

    @DynamoDBAttribute(attributeName = "desc")
    private String description;

    public Customer() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public long getContractExpiration() {
        return contractExpiration;
    }

    public void setContractExpiration(long contractExpiration) {
        this.contractExpiration = contractExpiration;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", contract='" + contract + '\'' +
                ", room='" + room + '\'' +
                ", area=" + area +
                ", rent=" + rent +
                ", contractExpiration=" + contractExpiration +
                ", contacts='" + contacts + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
