package com.hbcu.model.request;

public class CustomerRequest
{
    private String companyName;
    private int id;
    private String email;
    private String contacts;
    private String description;

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
        return "CustomerRequest{companyName='" + this.companyName + '\'' + ", id=" + this.id + ", email='" + this.email + '\'' + ", contacts='" + this.contacts + '\'' + ", description='" + this.description + '\'' + '}';
    }
}