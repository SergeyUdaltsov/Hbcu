package com.hbcu.model.dto;

import com.hbcu.model.Customer;
import com.hbcu.model.contract.serviceBalance.ContractBalance;

import java.util.List;

public class CustomerDto {

    private Customer customer;
    List<ContractBalance> balances;

    public CustomerDto() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ContractBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<ContractBalance> balances) {
        this.balances = balances;
    }
}
