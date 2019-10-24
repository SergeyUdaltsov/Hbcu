package com.hbcu.model.request;

import com.hbcu.model.Contract;

public class SignContractRequest {
    private int customerId;
    private Contract contract;

    public SignContractRequest() {
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Contract getContract() {
        return this.contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String toString() {
        return "SignContractRequest{customerId=" + this.customerId + ", contract=" + this.contract + '}';
    }
}