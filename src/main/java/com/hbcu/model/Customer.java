package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "Customers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    @DynamoDBAttribute(attributeName = "id")
    @DynamoDBHashKey
    private int id;
    @DynamoDBAttribute(attributeName = "cn")
    private String companyName;
    @DynamoDBAttribute(attributeName = "email")
    private String email;
    @DynamoDBAttribute(attributeName = "c")
    private List<Contract> contracts;
    @DynamoDBAttribute(attributeName = "cont")
    private String contacts;
    @DynamoDBAttribute(attributeName = "desc")
    private String description;

    public Customer() {
        this.contracts = new ArrayList<Contract>();
        this.contracts = new ArrayList<Contract>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(final List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getContacts() {
        return this.contacts;
    }

    public void setContacts(final String contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{id=" + this.id + ", companyName='" + this.companyName + '\'' + ", email='" + this.email + '\'' + ", contracts=" + this.contracts + ", contacts='" + this.contacts + '\'' + ", description='" + this.description + '\'' + '}';
    }
}