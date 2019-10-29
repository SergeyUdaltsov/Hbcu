package com.hbcu.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hbcu.model.contract.Contract;

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

    public static CustomerBuilder customerBuilder() {
        return new CustomerBuilder();
    }

    @Override
    public String toString() {
        return "Customer{id=" + this.id + ", companyName='" + this.companyName + '\'' + ", email='" + this.email + '\'' + ", contracts=" + this.contracts + ", contacts='" + this.contacts + '\'' + ", description='" + this.description + '\'' + '}';
    }

    public static class CustomerBuilder {

        private Customer customer;

        public CustomerBuilder() {
            this.customer = new Customer();
        }

        @JsonProperty("id")
        public CustomerBuilder withId(int id) {
            this.customer.setId(id);
            return this;
        }

        @JsonProperty("cn")
        public CustomerBuilder withCompanyName(String companyName) {
            this.customer.setCompanyName(companyName);
            return this;
        }

        @JsonProperty("c")
        public CustomerBuilder withContracts(List<Contract> contracts) {
            this.customer.setContracts(contracts);
            return this;
        }

        @JsonProperty("cont")
        public CustomerBuilder withContacts(String contacts) {
            this.customer.setContacts(contacts);
            return this;
        }

        @JsonProperty("email")
        public CustomerBuilder withEmail(String email) {
            this.customer.setEmail(email);
            return this;
        }

        @JsonProperty("desc")
        public CustomerBuilder withDescription(String description) {
            this.customer.setDescription(description);
            return this;
        }

        public Customer build() {
            return this.customer;
        }
    }
}