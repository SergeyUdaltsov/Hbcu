package com.hbcu.model.request;

public class CustomerRequest {

    private String companyName;
    private String email;
    private String contract;
    private String room;
    private double area;
    private double rent;
    private long contractExpiration;
    private String contacts;
    private String description;

    public CustomerRequest() {
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
}
