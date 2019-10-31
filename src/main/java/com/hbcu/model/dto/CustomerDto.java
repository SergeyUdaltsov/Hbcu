package com.hbcu.model.dto;

import com.hbcu.model.Customer;
import com.hbcu.model.contract.serviceBalance.ServiceBalance;

import java.util.List;

public class CustomerDto {

    private Customer customer;
    List<ServiceBalance> balances;

    public CustomerDto() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ServiceBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<ServiceBalance> balances) {
        this.balances = balances;
    }
}
