package com.hbcu.model.contract.serviceBalance;

import com.hbcu.model.contract.Payment;
import com.hbcu.model.contract.ServiceType;

import java.math.BigDecimal;
import java.util.List;

public class TableBalance {

    private ServiceType serviceType;
    private List<Payment> payments;
    private BigDecimal balance;

    public TableBalance() {
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static BalanceBuilder builder() {
        return new BalanceBuilder();
    }

    static class BalanceBuilder {

    }
}
